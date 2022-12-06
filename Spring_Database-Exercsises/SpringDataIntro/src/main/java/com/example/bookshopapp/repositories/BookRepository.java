package com.example.bookshopapp.repositories;

import com.example.bookshopapp.domain.entities.Book;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
