package com.example.bookapplication.dto;

import com.example.bookapplication.entity.Book;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.List;

public class AuthorDTO {


    private String name;





    public String getName() {
        return name;
    }

    public AuthorDTO setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "AuthorDTO{" +

                "name='" + name + '\'' +
                '}';
    }
}
