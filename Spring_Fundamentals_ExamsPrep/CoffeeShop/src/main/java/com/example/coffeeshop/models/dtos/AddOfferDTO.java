package com.example.coffeeshop.models.dtos;

import com.example.coffeeshop.models.entities.Category;
import com.example.coffeeshop.models.enums.CategoryType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddOfferDTO {
    @Size(min = 3, max = 20)
    @NotBlank
    private String name;


    @Positive
    @NotNull
    private BigDecimal price;


    @PastOrPresent
    @DateTimeFormat(pattern = "mm/dd/yyyy --:-- --")
    private LocalDateTime neededBefore;

    @NotNull
    private CategoryType category;

    @NotBlank
    @Size(min = 5)
    private String description;
}
