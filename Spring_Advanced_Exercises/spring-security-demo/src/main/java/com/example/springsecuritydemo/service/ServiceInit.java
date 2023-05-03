package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.model.entity.User;
import com.example.springsecuritydemo.model.entity.UserRole;
import com.example.springsecuritydemo.model.enums.RoleEnum;
import com.example.springsecuritydemo.repository.UserRepository;
import com.example.springsecuritydemo.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceInit {
    private final UserRoleRepository userRoleRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public ServiceInit(UserRoleRepository userRoleRepository, PasswordEncoder passwordEncoder, @Value("${app.default.password}") String defaultPassword, UserRepository userRepository) {
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    public void initRoles() {
        if (userRoleRepository.count() == 0) {
            var moderatorRole = new UserRole().setRole(RoleEnum.MODERATOR);
            var adminRole = new UserRole().setRole(RoleEnum.ADMIN);

            userRoleRepository.save(moderatorRole);
            userRoleRepository.save(adminRole);
        }

    }

    @PostConstruct
    public void init() {
        initRoles();
        initUsers();
    }

    private void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
            initModerator();
            initNormalUser();
        }
    }

    private void initAdmin() {
        var adminUser = new User().setEmail("LazarDukov@gmail.com")
                .setFirstName("Lazar")
                .setLastName("Dukov")
                .setPassword(passwordEncoder.encode("12345"))
                .setRoles(userRoleRepository.findAll());

        userRepository.save(adminUser);
    }


    private void initModerator() {
        var moderatorRole = this.userRoleRepository.findUserRoleByRole(RoleEnum.MODERATOR).orElseThrow();

        var moderatorUser = new User().setEmail("MishoIvanov@gmail.com")
                .setFirstName("Misho")
                .setLastName("Ivanov")
                .setPassword(passwordEncoder.encode("12345"))
                .setRoles(List.of(moderatorRole));

        userRepository.save(moderatorUser);
    }

    private void initNormalUser() {
        var normalUser = new User().setEmail("DonCeci@gmail.com")
                .setFirstName("Ceco")
                .setLastName("Goshev")
                .setPassword(passwordEncoder.encode("12345"));

        userRepository.save(normalUser);
    }

}
