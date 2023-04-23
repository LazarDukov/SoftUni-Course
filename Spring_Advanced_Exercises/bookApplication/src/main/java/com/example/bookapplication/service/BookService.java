package com.example.bookapplication.service;

import com.example.bookapplication.dto.AuthorDTO;
import com.example.bookapplication.dto.BookDTO;
import com.example.bookapplication.entity.Book;
import com.example.bookapplication.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(this::map).toList();
    }

    private BookDTO map(Book book) {
        AuthorDTO authorDTO = new AuthorDTO().setName(book.getAuthor().getName());
        return new BookDTO()
                .setId(book.getId())
                .setTitle(book.getTitle())
                .setIsbn(book.getIsbn())
                .setAuthor(authorDTO);
    }

    public Optional<BookDTO> findBookById(Long bookId) {
       return bookRepository.findById(bookId).map(this::map);
    }

}
