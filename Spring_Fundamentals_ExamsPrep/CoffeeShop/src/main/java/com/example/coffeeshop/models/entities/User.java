package com.example.coffeeshop.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column
    private String username;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String password;

    @Column
    private String email;

    @OneToMany(mappedBy = "employee")
    @Fetch(FetchMode.JOIN)
    private Set<Order> orders;

}
//•	Has an Id – UUID-string or Long
//•	Has a Username (unique)
//o	The length of the username must be between 5 and 20 characters (both numbers are INCLUSIVE).
//•	Has a First Name
//o	Can be null.
//•	Has a Last Name
//o	The length of the last name must be between 5 and 20 characters (both numbers are INCLUSIVE).
//•	Has a Password
//o	The length of the password must be more than 3 (INCLUSIVE).
//•	Has an Email
//o	Must contain a '@' symbol.
//o	The email must be unique
