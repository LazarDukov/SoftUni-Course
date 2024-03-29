package com.example.booksrestclient;

import com.example.booksrestclient.model.dto.BookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class BooksRestDemo implements CommandLineRunner {
    private static final String API_URL = "http://localhost:8080/api/books";
    private final RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(BooksRestDemo.API_URL);

    public BooksRestDemo(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        ResponseEntity<BookDTO[]> allBooksResponse =
                restTemplate.getForEntity(API_URL, BookDTO[].class);

        if (allBooksResponse.hasBody()) {
            BookDTO[] books = allBooksResponse.getBody();

            for (BookDTO book: books) {
                LOGGER.info("Retrieved a book: {}", book);
            }
        }
    }
}
