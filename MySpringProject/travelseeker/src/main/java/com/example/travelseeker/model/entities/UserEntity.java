package com.example.travelseeker.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column
    private String username;

    @Column
    private String firstName;
    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String country;

    @Column
    private int age;

    @Column
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserRoleEntity> roles = new ArrayList<>();

    @OneToMany
    private List<BoughtOffersEntity> cart;

    @OneToMany
    private List<BoughtOffersEntity> boughtOffers;

    public UserEntity() {
    }

    public UserEntity(String username, String firstName, String lastName, String email, String country, int age, String password, List<UserRoleEntity> roles) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.age = age;
        this.password = password;
        this.roles = roles;

    }

    public UserEntity addRole(UserRoleEntity role) {
        this.roles.add(role);
        return this;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserEntity setCountry(String country) {
        this.country = country;
        return this;
    }

    public UserEntity setAge(int age) {
        this.age = age;
        return this;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserEntity setRoles(List<UserRoleEntity> roles) {
        this.roles = roles;
        return this;
    }

    public UserEntity setCart(List<BoughtOffersEntity> cart) {
        this.cart = cart;
        return this;
    }

    public UserEntity setBoughtOffers(List<BoughtOffersEntity> boughtOffers) {
        this.boughtOffers = boughtOffers;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public int getAge() {
        return age;
    }

    public String getPassword() {
        return password;
    }

    public List<UserRoleEntity> getRoles() {
        return roles;
    }

    public List<BoughtOffersEntity> getCart() {
        return cart;
    }

    public List<BoughtOffersEntity> getBoughtOffers() {
        return boughtOffers;
    }
}
