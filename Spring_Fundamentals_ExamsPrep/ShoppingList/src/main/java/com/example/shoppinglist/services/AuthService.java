package com.example.shoppinglist.services;

import com.example.shoppinglist.models.dtos.UserLoginDTO;
import com.example.shoppinglist.models.dtos.UserRegistrationDTO;
import com.example.shoppinglist.models.entities.User;
import com.example.shoppinglist.repositories.UserRepository;
import com.example.shoppinglist.sessions.LoggedUser;
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
        return this.loggedUser.getId()>0;

    }

    public boolean register(UserRegistrationDTO userRegistrationDTO) {
        //check if user is created yet
        Optional<User> checkIsUsernameExist = userRepository.findAllByUsername(userRegistrationDTO.getUsername());
        if (checkIsUsernameExist.isPresent()) {
            return false;
        }

        //check if email is created yet
        Optional<User> checkIsEmailExist = userRepository.findAllByEmail(userRegistrationDTO.getEmail());
        if (checkIsEmailExist.isPresent()) {
            return false;
        }

        //check for password is the same
        if (!userRegistrationDTO.getPassword().equals(userRegistrationDTO.getConfirmPassword())) {
            return false;
        }
        User user = new User();
        user.setUsername(userRegistrationDTO.getUsername());
        user.setEmail(userRegistrationDTO.getEmail());
        user.setPassword(userRegistrationDTO.getPassword());
        userRepository.save(user);
        return true;
    }

    public boolean login(UserLoginDTO userLoginDTO) {
        Optional<User> user = userRepository.findAllByUsernameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword());
        if (user.isPresent()) {
            this.loggedUser.login(user.get());
            return true;
        }
        return false;

    }

    public void logout(){
        this.loggedUser.logout();
    }
}
