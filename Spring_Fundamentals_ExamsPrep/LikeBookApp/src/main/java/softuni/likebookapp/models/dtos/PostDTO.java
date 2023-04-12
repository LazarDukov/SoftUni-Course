package softuni.likebookapp.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.likebookapp.models.entities.Post;
import softuni.likebookapp.models.entities.User;
import softuni.likebookapp.models.enums.MoodType;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private String username;
    private MoodType mood;
    private int likes;
    private List<User> userLikes;
    private String content;

    public PostDTO(Post post) {
        this.id = post.getId();
        this.username = post.getUser().getUsername();
        this.mood = post.getMood().getMood();
        this.likes = post.getLikes();
        this.userLikes = post.getUserLikes();
        this.content = post.getContent();
    }
}
