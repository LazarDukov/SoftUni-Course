package com.example.shoppinglist.models.dtos;

import com.example.shoppinglist.models.entities.Category;
import com.example.shoppinglist.models.enums.CategoryType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddProductDTO {
    @Size(min = 3, max = 20)
    @NotBlank
    private String name;

    @Size(min = 5)
    @NotBlank
    private String description;

    @FutureOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd г. hh:mm")
    private LocalDateTime neededBefore;

    @Positive
    @NotNull
    private Double price;

    @NotNull
    private CategoryType category;

}
