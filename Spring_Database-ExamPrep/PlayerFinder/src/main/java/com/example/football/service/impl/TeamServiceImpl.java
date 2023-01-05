package com.example.football.service.impl;

import com.example.football.repository.PlayerRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.service.TeamService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.example.football.util.Paths.TEAMS_PATH;

@Service
public class TeamServiceImpl implements TeamService {

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    private final TeamRepository teamRepository;

    @Override
    public boolean areImported() {
        return teamRepository.count()>0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_PATH));
    }

    @Override
    public String importTeams() {
        return null;
    }
}
