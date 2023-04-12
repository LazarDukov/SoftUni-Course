package com.example.coffeeshop.services;

import com.example.coffeeshop.models.dtos.LoginDTO;
import com.example.coffeeshop.models.dtos.RegisterDTO;
import com.example.coffeeshop.models.entities.User;
import com.example.coffeeshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean isUserLogged() {
        return this.loggedUser.getId() != 0;
    }

    public boolean login(LoginDTO loginDTO) {
        Optional<User> hasUser = this.userRepository.findByUsername(loginDTO.getUsername());
        if (hasUser.isPresent()) {
            if (hasUser.get().getPassword().equals(loginDTO.getPassword())) {
                this.loggedUser.login(hasUser.get());
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean register(RegisterDTO registerDTO) {
        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            return false;
        }

        Optional<User> isUserExist = this.userRepository.findByUsername(registerDTO.getUsername());
        if (isUserExist.isPresent()) {
            return false;
        }

        Optional<User> isEmailExist = this.userRepository.findByEmail(registerDTO.getEmail());
        if (isEmailExist.isPresent()) {
            return false;
        }
        User user = new User();
        user.setUsername(registerDTO.getUsername());
        user.setFirstName(registerDTO.getFirstName());
        user.setEmail(registerDTO.getEmail());
        user.setLastName(registerDTO.getLastName());
        user.setPassword(registerDTO.getPassword());

        this.userRepository.save(user);
        return true;

    }

    public void logout() {
        this.loggedUser.logout();
    }

}
