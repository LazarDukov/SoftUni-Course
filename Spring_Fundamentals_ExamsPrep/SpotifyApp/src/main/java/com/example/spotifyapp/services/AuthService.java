package com.example.spotifyapp.services;

import com.example.spotifyapp.models.dtos.LoginDTO;
import com.example.spotifyapp.models.dtos.RegisterDTO;
import com.example.spotifyapp.models.entities.User;
import com.example.spotifyapp.repositories.UserRepository;
import com.example.spotifyapp.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final LoggedUser loggedUser;

    @Autowired
    public AuthService(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    public boolean checkRegisterValidations(RegisterDTO registerDTO) {
        Optional<User> isUserExist = this.userRepository.findByUsername(registerDTO.getUsername());
        if (isUserExist.isPresent()) {
            return false;
        }
        Optional<User> isEmailExist = this.userRepository.findByUsername(registerDTO.getEmail());
        if (isEmailExist.isPresent()) {
            return false;
        }
        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            return false;
        }
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setEmail(registerDTO.getEmail());
        user.setPassword(registerDTO.getPassword());
        user.setPlaylist(new ArrayList<>());
        this.userRepository.save(user);
        return true;
    }

    public boolean checkLoginValidations(LoginDTO loginDTO) {
        if (this.userRepository.findByUsername(loginDTO.getUsername()).isPresent()) {
            String passwordCheck = this.userRepository.findByUsername(loginDTO.getUsername()).get().getPassword();
            if (passwordCheck.equals(loginDTO.getPassword())) {
                this.loggedUser.logIn(this.userRepository.findByUsername(loginDTO.getUsername()).get());
                return true;
            }
        }

        return false;
    }


}
