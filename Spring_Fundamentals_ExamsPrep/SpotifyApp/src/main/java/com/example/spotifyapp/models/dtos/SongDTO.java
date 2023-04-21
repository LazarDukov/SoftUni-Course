package com.example.spotifyapp.models.dtos;

import com.example.spotifyapp.models.entities.Song;

public class SongDTO {
    private Long id;
    //{performer} - {title} ({duration} min)
    private String performer;

    private String title;

    private Integer durationMinutes;
    private Integer durationSeconds;

    private Integer durationOnlyInSeconds;

    private Integer durationOfTotalSongs;

    @Override
    public String toString() {
        return String.format("%d:%02d", durationMinutes, durationSeconds);
    }

    public String toStringTotal() {
        return String.format("%d:%02d", durationOnlyInSeconds);
    }

    public SongDTO() {
    }

    public SongDTO(Long id, String performer, String title, Integer durationMinutes, Integer durationSeconds, Integer durationOfTotalSongs) {
        this.id = id;
        this.performer = performer;
        this.title = title;
        this.durationMinutes = durationMinutes;
        this.durationSeconds = durationSeconds;
        this.durationOfTotalSongs = durationOfTotalSongs;
    }

    public Integer getDurationOnlyInSeconds() {
        return durationOnlyInSeconds;
    }

    public SongDTO setDurationOnlyInSeconds(Integer durationOnlyInSeconds) {
        this.durationOnlyInSeconds = durationOnlyInSeconds;
        return this;
    }

    public SongDTO(Song song) {
        this.id = song.getId();
        this.performer = song.getPerformer();
        this.title = song.getTitle();
        this.durationMinutes = minutes(song);
        this.durationSeconds = seconds(song);
        this.durationOnlyInSeconds = song.getDuration();
    }

    private Integer minutes(Song song) {
        return (song.getDuration() % 3600) / 60;
    }

    private Integer seconds(Song song) {
        return song.getDuration() % 60;
    }


    public Long getId() {
        return id;
    }

    public SongDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getPerformer() {
        return performer;
    }

    public SongDTO setPerformer(String performer) {
        this.performer = performer;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SongDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public SongDTO setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
        return this;
    }

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    public SongDTO setDurationSeconds(Integer durationSeconds) {
        this.durationSeconds = durationSeconds;
        return this;
    }

    public Integer getDurationOfTotalSongs() {
        return durationOfTotalSongs;
    }

    public SongDTO setDurationOfTotalSongs(Integer durationOfTotalSongs) {
        this.durationOfTotalSongs = durationOfTotalSongs;
        return this;
    }
}
