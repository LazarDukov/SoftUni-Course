package com.example.football.service.impl;

import com.example.football.models.dto.PlayerImportDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.StatRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.PlayerService;
import com.example.football.models.dto.PlayerWrapperDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.example.football.util.Paths.PLAYERS_PATH;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;

    private final TeamRepository teamRepository;
    private final TownRepository townRepository;
    private final StatRepository statRepository;

    private ModelMapper modelMapper;

    private Validator validator;

    public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository, TownRepository townRepository, StatRepository statRepository, ModelMapper modelMapper, Validator validator) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
        this.statRepository = statRepository;
        this.modelMapper = modelMapper;
        this.validator = validator;
    }

    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {
        return Files.readString(Path.of(PLAYERS_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(PlayerWrapperDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        PlayerWrapperDto playersDto = (PlayerWrapperDto) unmarshaller.unmarshal(Path.of(PLAYERS_PATH).toFile());

        List<PlayerImportDto> players = playersDto.getPlayers();

        List<String> result = new ArrayList<>();

        for (PlayerImportDto playerDto : players) {
            Set<ConstraintViolation<PlayerImportDto>> errors = validator.validate(playerDto);
            if (errors.isEmpty()) {
                Optional<Player> isExistByEmail = this.playerRepository.findByEmail(playerDto.getEmail());
                if (isExistByEmail.isEmpty()) {
                    Player player = this.modelMapper.map(playerDto, Player.class);
                    Optional<Team> team = this.teamRepository.findByName(playerDto.getTeam().getName());
                    Optional<Town> town = this.townRepository.findByName(playerDto.getTown().getName());
                    Optional<Stat> stat = this.statRepository.findById(playerDto.getStatId().getId());
                    player.setTeam(team.get());
                    player.setTown(town.get());
                    player.setStat(stat.get());
                    this.playerRepository.save(player);
                    result.add(String.format("Successfully imported Player %s %s - %s", player.getFirstName(), player.getLastName(), player.getPosition()));
                } else {
                    result.add("Invalid player");
                }
            } else {
                result.add("Invalid player");
            }
        }

        return String.join(System.lineSeparator(), result);
    }

    @Override
    public String exportBestPlayers() {
        return null;
    }
}
