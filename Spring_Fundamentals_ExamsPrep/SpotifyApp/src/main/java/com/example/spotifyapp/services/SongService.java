package com.example.spotifyapp.services;

import com.example.spotifyapp.models.dtos.AddSongDTO;
import com.example.spotifyapp.models.dtos.SongDTO;
import com.example.spotifyapp.models.entities.Song;
import com.example.spotifyapp.models.entities.Style;
import com.example.spotifyapp.models.entities.User;
import com.example.spotifyapp.models.enums.StyleName;
import com.example.spotifyapp.repositories.SongRepository;
import com.example.spotifyapp.repositories.StyleRepository;
import com.example.spotifyapp.repositories.UserRepository;
import com.example.spotifyapp.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class SongService {
    private final SongRepository songRepository;

    private final StyleRepository styleRepository;
    private final UserRepository userRepository;

    @Autowired
    public SongService(SongRepository songRepository, StyleRepository styleRepository, UserRepository userRepository) {
        this.songRepository = songRepository;
        this.styleRepository = styleRepository;
        this.userRepository = userRepository;
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

    public List<SongDTO> getAllSongs(StyleName styleName) {
        return this.songRepository.findAllByStyleNameIs(styleName).stream().map(SongDTO::new).collect(Collectors.toList());


    }

    public List<SongDTO> getUserPlaylist(LoggedUser loggedUser) {
        return this.userRepository.findById(loggedUser.getId()).orElseThrow().getPlaylist().stream().map(SongDTO::new).collect(Collectors.toList());
    }

    public void addSongsByUser(Long songId, Long userId) {
        Song song = this.songRepository.findById(songId).orElse(null);
        User user = this.userRepository.findById(userId).orElse(null);

        assert user != null;
        if (user.getPlaylist().stream().noneMatch(x -> x.getId().equals(song.getId()))) {
            user.getPlaylist().add(song);
            this.userRepository.save(user);
        }
    }

    public void removeAllSongsFromPlaylist(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(null);
        user.removeAllSongsFromPlaylist();
        userRepository.save(user);

    }
}
