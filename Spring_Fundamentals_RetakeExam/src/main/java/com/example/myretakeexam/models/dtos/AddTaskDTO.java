package com.example.myretakeexam.models.dtos;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddTaskDTO {
    @Size(min = 2, max = 50, message = "Description length must be between 2 and 50 characters!")
    @NotNull(message = "")
    private String description;

    @Future(message = "Due Date must be in the future!")
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull(message = "Due Date must be in the future!")
    private LocalDate dueDate;

    @NotBlank(message = "You must select a priority!")
    private String priority;
}
