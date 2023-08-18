package handball.core;

import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static handball.common.ConstantMessages.*;
import static handball.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private Repository equipment;
    private Collection<Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        Gameplay gameplay = null;
        switch (gameplayType) {
            case "Outdoor":
                gameplay = new Outdoor(gameplayName);
                break;
            case "Indoor":
                gameplay = new Indoor(gameplayName);
                break;
            default:
                throw new NullPointerException(INVALID_GAMEPLAY_TYPE);
        }
        gameplays.add(gameplay);
        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        Equipment equipment1 = null;
        switch (equipmentType) {
            case "Kneepad":
                equipment1 = new Kneepad();
                break;
            case "ElbowPad":
                equipment1 = new ElbowPad();
                break;
            default:
                throw new IllegalArgumentException(INVALID_EQUIPMENT_TYPE);
        }
        equipment.add(equipment1);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment equipmentGiven = equipment.findByType(equipmentType);
        if (equipmentGiven == null) {
            throw new IllegalArgumentException(String.format(NO_EQUIPMENT_FOUND, equipmentType));
        }
        Gameplay gameplay = gameplays.stream().filter(g -> g.getName().equals(gameplayName)).findAny().get();
        gameplay.addEquipment(equipmentGiven);
        equipment.remove(equipmentGiven);
        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);
    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        Team team = null;
        switch (teamType) {
            case "Bulgaria":
                team = new Bulgaria(teamName, country, advantage);
                break;
            case "Germany":
                team = new Germany(teamName, country, advantage);
                break;
            default:
                throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        }
        Gameplay gameplay = gameplays.stream().filter(g -> g.getName().equals(gameplayName)).findAny().get();
        if ((team.getClass().getSimpleName().equals("Bulgaria") && gameplay.getClass().getSimpleName().equals("Indoor")) ||
                (team.getClass().getSimpleName().equals("Germany") && gameplay.getClass().getSimpleName().equals("Outdoor"))) {
            return GAMEPLAY_NOT_SUITABLE;
        }
        gameplay.addTeam(team);
        return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = gameplays.stream().filter(g -> g.getName().equals(gameplayName)).findAny().get();
        gameplay.teamsInGameplay();
        int count = gameplay.getTeam().size();
        return String.format(TEAMS_PLAYED, count);


    }

    @Override
    public String percentAdvantage(String gameplayName) {
        Gameplay gameplay = gameplays.stream().filter(g -> g.getName().equals(gameplayName)).findAny().get();
        int sum = gameplay.getTeam().stream().mapToInt(Team::getAdvantage).sum();
        return String.format(ADVANTAGE_GAMEPLAY, gameplayName, sum);
    }

    @Override
    public String getStatistics() {
        return gameplays.stream().map(Gameplay::toString).collect(Collectors.joining(System.lineSeparator()));
    }
}
