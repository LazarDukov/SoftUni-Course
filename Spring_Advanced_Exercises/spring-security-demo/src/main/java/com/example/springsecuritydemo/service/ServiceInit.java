package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.model.entity.UserRole;
import com.example.springsecuritydemo.model.enums.RoleEnum;
import com.example.springsecuritydemo.repository.UserRepository;
import com.example.springsecuritydemo.repository.UserRoleRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class ServiceInit {
    private final UserRoleRepository userRoleRepository;

    public ServiceInit(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @PostConstruct
    public void initUsers() {
        if (userRoleRepository.count() == 0) {
            var moderatorRole = new UserRole().setRole(RoleEnum.MODERATOR);
            var adminRole = new UserRole().setRole(RoleEnum.ADMIN);

            userRoleRepository.save(moderatorRole);
            userRoleRepository.save(adminRole);
        }

    }
}
