package com.example.football.service.impl;

import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.example.football.util.Paths.PLAYERS_PATH;
import static com.example.football.util.Paths.TEAMS_PATH;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count()>0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_PATH));
    }

    @Override
    public String importPlayers()  {
        return null;
    }

    @Override
    public String exportBestPlayers() {
        return null;
    }
}
