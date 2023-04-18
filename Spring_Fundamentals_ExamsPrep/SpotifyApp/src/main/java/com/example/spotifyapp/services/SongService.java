package com.example.spotifyapp.services;

import com.example.spotifyapp.models.dtos.AddSongDTO;
import com.example.spotifyapp.models.entities.Song;
import com.example.spotifyapp.models.entities.Style;
import com.example.spotifyapp.models.enums.StyleName;
import com.example.spotifyapp.repositories.SongRepository;
import com.example.spotifyapp.repositories.StyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {
    private final SongRepository songRepository;

    private final StyleRepository styleRepository;

    @Autowired
    public SongService(SongRepository songRepository, StyleRepository styleRepository) {
        this.songRepository = songRepository;
        this.styleRepository = styleRepository;
    }

    public void addSong(AddSongDTO addSongDTO) {
        StyleName enumValue = switch (addSongDTO.getStyle().toString().toUpperCase()) {
            case "POP" -> StyleName.POP;
            case "ROCK" -> StyleName.ROCK;
            case "JAZZ" -> StyleName.JAZZ;
            default -> StyleName.POP;
        };

        Style style = this.styleRepository.findByName(enumValue);


        Song song = new Song();
        song.setPerformer(addSongDTO.getPerformer());
        song.setTitle(addSongDTO.getTitle());
        song.setReleaseDate(addSongDTO.getReleaseDate());
        song.setDuration(addSongDTO.getDurationInSeconds());
        song.setStyle(style);
        this.songRepository.save(song);
    }
}
