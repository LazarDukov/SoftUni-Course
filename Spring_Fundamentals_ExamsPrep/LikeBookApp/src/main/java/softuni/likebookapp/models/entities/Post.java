package softuni.likebookapp.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post extends BaseEntity {
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> userLikes;

    @ManyToOne(fetch = FetchType.EAGER)
    private Mood mood;
    //Post
    //•	Has an Id – “UUID-String” or Long
    //•	Has a Content (not null)
    //o	Content length must be between 2 and 150 characters (inclusive of 2 and 150).
    //•	Has a User (not null)
    //o	The creator of the post. One post can have only one user and one user may have many posts.
    //•	Has a User Likes
    //o	The user likes contains users. One user may like many posts and one post can be liked by many users.
    //•	Has a Mood (not null)
    //o	One post has one mood and one mood can have many posts.
}
