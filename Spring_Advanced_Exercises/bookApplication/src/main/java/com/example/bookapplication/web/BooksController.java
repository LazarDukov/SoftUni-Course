package com.example.bookapplication.web;

import com.example.bookapplication.dto.BookDTO;
import com.example.bookapplication.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long bookId) {
        Optional<BookDTO> book = bookService.findBookById(bookId);
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable("id") Long bookId) {
        bookService.deleteBookById(bookId);
    }

    @PostMapping("")
    public ResponseEntity<BookDTO> createNewBook(@RequestBody BookDTO newBook, UriComponentsBuilder uriComponentsBuilder) {
       long newBookId = bookService.createBook(newBook);

       return ResponseEntity.created(uriComponentsBuilder.path("/api/books/{id}").build(newBookId)).build();
    }
}
