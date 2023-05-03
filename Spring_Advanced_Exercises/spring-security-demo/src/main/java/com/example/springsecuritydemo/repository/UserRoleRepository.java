package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.model.entity.UserRole;
import com.example.springsecuritydemo.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findUserRoleByRole(RoleEnum role);
}
