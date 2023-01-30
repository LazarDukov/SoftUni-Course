package com.example.football.service.impl;

import com.example.football.models.dto.TeamImportDto;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TeamService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.example.football.util.Paths.TEAMS_PATH;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    private final Validator validator;

    private final TownRepository townRepository;

    public TeamServiceImpl(TeamRepository teamRepository, Gson gson, ModelMapper modelMapper, Validator validator, TownRepository townRepository) {
        this.teamRepository = teamRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validator = validator;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {
        return teamRepository.count() > 0;
    }

    @Override
    public String readTeamsFileContent() throws IOException {
        return Files.readString(Path.of(TEAMS_PATH));
    }

    @Override
    public String importTeams() throws IOException {
        final String reader = readTeamsFileContent();
        TeamImportDto[] teamImportDtos = this.gson.fromJson(reader, TeamImportDto[].class);
        List<String> result = new ArrayList<>();

        for (TeamImportDto teamImportDto : teamImportDtos) {
            Set<ConstraintViolation<TeamImportDto>> errors = this.validator.validate(teamImportDto);
            if (errors.isEmpty()) {
                Optional<Team> isTeamExists = this.teamRepository.findByName(teamImportDto.getName());
                if (isTeamExists.isEmpty()) {
                    Team team = this.modelMapper.map(teamImportDto, Team.class);
                    Optional<Town> town = this.townRepository.findByName(teamImportDto.getTownName());

                    team.setTown(town.get());
                    this.teamRepository.save(team);


                    result.add(String.format("Successfully imported Team " + team.toString()));

                } else {
                    result.add("Invalid team");
                }
            } else {
                result.add("Invalid team");
            }
        }
        return String.join(System.lineSeparator(), result);
    }
}
