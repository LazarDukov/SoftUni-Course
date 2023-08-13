package softuni.exam.models.dto;


import softuni.exam.models.entity.Genre;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class BookImportDto {
    ////Book

    //    //•	title – accepts char sequence (between 3 to 40 inclusive). The values are unique in the database.
    //    //•	author - accepts char sequence (between 3 to 40 inclusive).
    //    //•	description - a long and detailed description about the book with a character length value higher than or equal to 5.
    //    //•	available – accepts a true or false, representing the availability status of the book.
    //    //•	genre – String enumeration, one of the following – CLASSIC_LITERATURE, SCIENCE_FICTION, FANTASY
    //    //•	rating – accepts number values that are positive.
//----------------------------------------
    //    "author": "Harper Lee",
    //    "available": true,
    //    "description": "A powerful story addressing racial injustice",
    //    "genre": "CLASSIC_LITERATURE",
    //    "title": "To Kill a Mockingbird",
    //    "rating": 5.6
    @NotNull
    @Size(min = 3, max = 40)
    private String title;

    @NotNull
    @Size(min = 3, max = 40)
    private String author;

    @NotNull
    @Size(min = 5)
    private String description;

    @NotNull
    private boolean available;


    @NotNull
    private Genre genre;

    @NotNull
    @Positive
    private Double rating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
