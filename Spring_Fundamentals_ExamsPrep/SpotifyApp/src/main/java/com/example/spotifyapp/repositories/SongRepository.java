package com.example.spotifyapp.repositories;

import com.example.spotifyapp.models.entities.Song;
import com.example.spotifyapp.models.entities.User;
import com.example.spotifyapp.models.enums.StyleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findAllByStyleNameIs(StyleName styleName);


}
