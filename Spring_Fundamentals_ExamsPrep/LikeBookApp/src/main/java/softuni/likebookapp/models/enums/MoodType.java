package softuni.likebookapp.models.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum MoodType {
    HAPPY, SAD, INSPIRED;

    private String mood;
}
