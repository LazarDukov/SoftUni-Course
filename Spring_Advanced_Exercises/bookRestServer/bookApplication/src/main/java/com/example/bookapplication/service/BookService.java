package com.example.bookapplication.service;

import com.example.bookapplication.dto.AuthorDTO;
import com.example.bookapplication.dto.BookDTO;
import com.example.bookapplication.entity.Author;
import com.example.bookapplication.entity.Book;
import com.example.bookapplication.repository.AuthorRepository;
import com.example.bookapplication.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
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

    public void deleteBookById(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public long createBook(BookDTO newBook) {
        String author = newBook.getAuthor().getName();
        Optional<Author> authorOpt = this.authorRepository.findByName(author);

        Book createNewBook = new Book()
                .setTitle(newBook.getTitle())
                .setIsbn(newBook.getIsbn())
                .setAuthor(authorOpt.orElseGet(()->createNewAuthor(author)));

       return bookRepository.save(createNewBook).getId();
    }

    private Author createNewAuthor(String author) {
       return this.authorRepository.save(new Author().setName(author));
    }
}
