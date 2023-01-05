package com.example.football.service.impl;

import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.example.football.util.Paths.STATS_PATH;
import static com.example.football.util.Paths.TEAMS_PATH;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;

    public StatServiceImpl(StatRepository statRepository) {
        this.statRepository = statRepository;
    }

    @Override
    public boolean areImported() {
        return statRepository.count()>0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of(STATS_PATH));
    }

    @Override
    public String importStats() {
        return null;
    }
}
