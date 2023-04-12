package softuni.likebookapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.likebookapp.models.dtos.LoginDTO;
import softuni.likebookapp.models.dtos.RegistrationDTO;
import softuni.likebookapp.models.entities.User;
import softuni.likebookapp.repositories.UserRepository;
import softuni.likebookapp.session.LoggedUser;

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

    public boolean userRegister(RegistrationDTO registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            return false;
        }
        if (this.userRepository.findByUsername(registrationDTO.getUsername()).isPresent()) {
            return false;
        }
        if (this.userRepository.findByEmail(registrationDTO.getEmail()).isPresent()) {
            return false;
        }
        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(registrationDTO.getPassword());
        user.setEmail(registrationDTO.getEmail());
        this.userRepository.save(user);
        return true;
    }

    public boolean userLogin(LoginDTO loginDTO) {
        Optional<User> user = this.userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        if (user.isEmpty()) {
            return false;
        }
        loggedUser.login(user.get());
        return true;

    }

    public Long getLoggedUserId() {
        return this.loggedUser.getId();
    }
}