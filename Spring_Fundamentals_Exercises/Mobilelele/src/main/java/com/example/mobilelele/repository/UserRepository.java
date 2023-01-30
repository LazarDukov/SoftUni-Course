package com.example.mobilelele.repository;

import com.example.mobilelele.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
