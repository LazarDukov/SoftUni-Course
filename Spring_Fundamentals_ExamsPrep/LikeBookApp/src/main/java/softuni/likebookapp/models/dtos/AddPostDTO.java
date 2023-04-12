package softuni.likebookapp.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddPostDTO {
    private Long id;

    @Size(min = 2, max = 150)
    @NotBlank
    private String content;

    @NotBlank
    private String mood;
}
