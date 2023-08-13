package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BookImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;
import softuni.exam.util.ValidationUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;


import static softuni.exam.util.Paths.PATH_BOOKS;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final Gson gson;

    private final Validator validator;

    private final ModelMapper modelMapper;

    private final ValidationUtils validationUtils;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, Gson gson, Validator validator, ModelMapper modelMapper, ValidationUtils validationUtils) {
        this.bookRepository = bookRepository;
        this.gson = gson;
        this.validator = validator;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return bookRepository.count() > 0;
    }

    @Override
    public String readBooksFromFile() throws IOException {
        return Files.readString(Path.of(PATH_BOOKS));
    }

    @Override
    public String importBooks() throws IOException {
        String json = this.readBooksFromFile();
        BookImportDto[] bookImportDtos = this.gson.fromJson(json, BookImportDto[].class);
        List<String> result = new ArrayList<>();

        for (BookImportDto bookImport : bookImportDtos) {
            Set<ConstraintViolation<BookImportDto>> errors = this.validator.validate(bookImport);
            if (errors.isEmpty()) {
                Optional<Book> isBookExists = bookRepository.findByTitle(bookImport.getTitle());
                if (isBookExists.isEmpty()) {
                    Book newBook = this.modelMapper.map(bookImport, Book.class);
                    bookRepository.save(newBook);

                    result.add(String.format("Successfully imported book %s - %s", bookImport.getAuthor(), bookImport.getTitle()));
                } else {
                    result.add("Invalid book");
                }
            } else {
                result.add("Invalid book");
            }

        }

        return String.join(System.lineSeparator(), result);
    }

}
