package softuni.likebookapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.likebookapp.models.entities.Post;
import softuni.likebookapp.models.entities.User;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByUserId(Long id);
    List<Post> findByUserIdNot(Long id);
}
