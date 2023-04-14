package com.example.myretakeexam.models.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    @NotNull
    private String username;

    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!")
    @NotNull
    private String password;
}
