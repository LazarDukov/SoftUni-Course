package com.example.football.models.dto;

import com.example.football.models.entity.Player;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerWrapperDto {
    @XmlElement(name = "player")
    private List<PlayerImportDto> players;

    public PlayerWrapperDto() {
    }

    public PlayerWrapperDto(List<PlayerImportDto> players) {
        this.players = players;
    }

    public List<PlayerImportDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerImportDto> players) {
        this.players = players;
    }
}
