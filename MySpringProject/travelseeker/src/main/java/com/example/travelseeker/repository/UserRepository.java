package com.example.travelseeker.repository;


import com.example.travelseeker.model.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
Optional<UserEntity> findUserEntityByUsername(String username);
}
