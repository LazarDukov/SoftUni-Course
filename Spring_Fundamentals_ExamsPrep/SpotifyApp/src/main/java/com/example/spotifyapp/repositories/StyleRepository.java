package com.example.spotifyapp.repositories;

import com.example.spotifyapp.models.entities.Style;
import com.example.spotifyapp.models.enums.StyleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {

    Style findByName(StyleName enumValue);
}
