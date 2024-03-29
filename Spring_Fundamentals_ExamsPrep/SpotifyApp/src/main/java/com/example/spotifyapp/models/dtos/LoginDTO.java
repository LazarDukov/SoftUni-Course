package com.example.spotifyapp.models.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginDTO {

    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!(inclusive 3 and 20).")
    private String username;

    @Size(min = 3, max = 20, message = "Password length must be between 3 and 20 characters!(inclusive 3 and 20).")
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public LoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
