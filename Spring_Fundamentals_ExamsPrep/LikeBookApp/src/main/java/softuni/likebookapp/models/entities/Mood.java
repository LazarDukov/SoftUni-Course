package softuni.likebookapp.models.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.likebookapp.models.enums.MoodType;

@Entity
@Table(name = "moods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mood extends BaseEntity {
    //•	Has an Id – “UUID-String” or Long
    //•	Has a Mood name (unique, not null)
    //o	an option between (Happy, Sad and Inspired)
    //•	Has a Description (optional)

    private MoodType mood;
    private String description;
}
