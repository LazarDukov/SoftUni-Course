package softuni.likebookapp.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import softuni.likebookapp.models.entities.Mood;
import softuni.likebookapp.models.enums.MoodType;
import softuni.likebookapp.repositories.MoodRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DbInit implements CommandLineRunner {
    private final MoodRepository moodRepository;

    @Autowired
    public DbInit(MoodRepository moodRepository) {
        this.moodRepository = moodRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        List<MoodType> moodList = List.of(MoodType.values());
        if (this.moodRepository.count() == 0) {
            for (MoodType m : moodList) {
                Mood mood = new Mood();
                mood.setMood(m);
                this.moodRepository.save(mood);
            }
        }

    }
}
