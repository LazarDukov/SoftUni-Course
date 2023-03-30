package com.example.shoppinglist.repositories;

import com.example.shoppinglist.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User ,Long> {
    Optional<User> findAllByUsername(String username);

    Optional<User> findAllByEmail(String email);

    Optional<User> findAllByUsernameAndPassword(String username, String password);
}
