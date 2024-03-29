package com.example.springsecuritydemo.model.entity;

import com.example.springsecuritydemo.model.enums.RoleEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum role;



    public Long getId() {
        return id;
    }

    public UserRole setId(Long id) {
        this.id = id;
        return this;
    }

    public RoleEnum getRole() {
        return role;
    }

    public UserRole setRole(RoleEnum role) {
        this.role = role;
        return this;
    }
}
