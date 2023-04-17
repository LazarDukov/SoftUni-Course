package com.example.spotifyapp.init;


import com.example.spotifyapp.models.entities.Style;
import com.example.spotifyapp.models.enums.StyleName;
import com.example.spotifyapp.repositories.StyleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class DbInit implements CommandLineRunner {
    private final StyleRepository styleRepository;

    public DbInit(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (styleRepository.count() == 0) {
            List<Style> styles = Arrays.stream(StyleName.values()).map(Style::new).toList();
            this.styleRepository.saveAll(styles);
        }
    }
}
