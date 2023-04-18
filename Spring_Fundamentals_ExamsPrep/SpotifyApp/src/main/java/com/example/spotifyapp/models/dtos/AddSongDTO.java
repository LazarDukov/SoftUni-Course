package com.example.spotifyapp.models.dtos;

import com.example.spotifyapp.models.entities.Style;
import com.example.spotifyapp.models.enums.StyleName;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public class AddSongDTO {
    @Size(min = 3, max = 20)
    @NotBlank
    private String performer;
    @Size(min = 2, max = 20)
    @NotBlank
    private String title;

    @PastOrPresent
    @NotNull
    private LocalDate releaseDate;

    @Positive
    @NotNull
    private Integer durationInSeconds;

    @NotNull
    private StyleName style;

    public AddSongDTO() {
    }

    public AddSongDTO(String performer, String title, LocalDate releaseDate, Integer durationInSeconds, StyleName style) {
        this.performer = performer;
        this.title = title;
        this.releaseDate = releaseDate;
        this.durationInSeconds = durationInSeconds;
        this.style = style;
    }

    public String getPerformer() {
        return performer;
    }

    public AddSongDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public AddSongDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public AddSongDTO setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public Integer getDurationInSeconds() {
        return durationInSeconds;
    }

    public AddSongDTO setDurationInSeconds(Integer durationInSeconds) {
        this.durationInSeconds = durationInSeconds;
        return this;
    }

    public StyleName getStyle() {
        return style;
    }

    public AddSongDTO setStyle(StyleName style) {
        this.style = style;
        return this;
    }
}
