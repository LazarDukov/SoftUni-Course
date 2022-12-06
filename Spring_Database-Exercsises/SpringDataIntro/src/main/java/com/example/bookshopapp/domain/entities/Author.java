package com.example.bookshopapp.domain.entities;


import lombok.*;

import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;
import java.util.Set;



@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Author extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @OneToMany(targetEntity = Book.class, mappedBy = "author")
    private Set<Book> books;


}
