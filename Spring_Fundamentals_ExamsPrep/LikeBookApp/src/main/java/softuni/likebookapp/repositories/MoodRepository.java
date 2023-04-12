package softuni.likebookapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.likebookapp.models.entities.Mood;
import softuni.likebookapp.models.entities.User;
import softuni.likebookapp.models.enums.MoodType;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {
    Mood findByMood(MoodType moodType);
}
