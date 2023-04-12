package softuni.likebookapp.services;

import org.springframework.stereotype.Service;
import softuni.likebookapp.models.dtos.AddPostDTO;
import softuni.likebookapp.models.dtos.PostDTO;
import softuni.likebookapp.models.entities.Mood;
import softuni.likebookapp.models.entities.Post;
import softuni.likebookapp.models.entities.User;
import softuni.likebookapp.models.enums.MoodType;
import softuni.likebookapp.repositories.MoodRepository;
import softuni.likebookapp.repositories.PostRepository;
import softuni.likebookapp.repositories.UserRepository;
import softuni.likebookapp.session.LoggedUser;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final UserRepository userRepository;
    private final MoodRepository moodRepository;
    private final PostRepository postRepository;

    private final LoggedUser loggedUser;

    public PostService(UserRepository userRepository, MoodRepository moodRepository, PostRepository postRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.moodRepository = moodRepository;
        this.postRepository = postRepository;
        this.loggedUser = loggedUser;
    }


    public boolean addPost(AddPostDTO addPostDTO) {
        Optional<User> isUserLogged = this.userRepository.findById(this.loggedUser.getId());
        if (isUserLogged.isEmpty()) {
            return false;
        }
        MoodType moodType = switch (addPostDTO.getMood().toUpperCase()) {
            case "HAPPY" -> MoodType.HAPPY;
            case "SAD" -> MoodType.SAD;
            case "INSPIRED" -> MoodType.INSPIRED;
            default -> MoodType.HAPPY;

        };
        Mood mood = this.moodRepository.findByMood(moodType);

        Post post = new Post();
        post.setContent(addPostDTO.getContent());
        post.setMood(mood);
        post.setUser(isUserLogged.get());
        this.postRepository.save(post);
        return true;
    }

    public List<PostDTO> getUserPosts(Long loggedUserId) {
        return this.postRepository.findByUserId(loggedUserId).stream().map(PostDTO::new).collect(Collectors.toList());

    }

    public List<PostDTO> getNotUserPosts(Long loggedUserId) {
        return this.postRepository.findByUserIdNot(loggedUserId).stream().map(PostDTO::new).collect(Collectors.toList());
    }


    public void removePostById(Long id) {
        this.postRepository.deleteById(id);
    }

    public void likePostWithId(Long postId, Long userId) {
        Post post = postRepository.findById(postId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        post.getUserLikes().add(user);
        post.setLikes(post.getLikes() + 1);
        postRepository.save(post);
    }
}
