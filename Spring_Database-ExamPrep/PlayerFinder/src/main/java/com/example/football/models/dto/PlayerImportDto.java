package com.example.football.models.dto;

import com.example.football.models.entity.Stat;
import com.example.football.models.entity.Team;
import com.example.football.models.entity.Town;
import com.example.football.util.LocalDateAdapter;
import com.example.football.util.Position;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Date;

@XmlRootElement(name = "player")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerImportDto {

    @XmlElement(name = "first-name")
    @Size(min = 3)
    @NotNull
    private String firstName;

    @XmlElement(name = "last-name")
    @Size(min = 3)
    @NotNull
    private String lastName;

    @XmlElement
    @Email(regexp = "^([a-z0-9_.-]+)@([da-z.-]+).([a-z.]{2,63})$")
    @NotNull
    private String email;

    @XmlElement(name = "birth-date")
    @NotNull
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate birthDate;

    @XmlElement
    @NotNull
    private Position position;

    @XmlElement(name = "town")
    @NotNull
    private PlayerTownImportDto town;

    @XmlElement(name = "team")
    @NotNull
    private PlayerTeamImportDto team;

    @XmlElement(name = "stat")
    @NotNull
    private PlayerStatImportDto statId;

    public PlayerImportDto() {
    }

    public PlayerImportDto(String firstName, String lastName, String email, LocalDate birthDate, Position position, PlayerTownImportDto town, PlayerTeamImportDto team, PlayerStatImportDto statId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.position = position;
        this.town = town;
        this.team = team;
        this.statId = statId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public PlayerTownImportDto getTown() {
        return town;
    }

    public void setTown(PlayerTownImportDto town) {
        this.town = town;
    }

    public PlayerTeamImportDto getTeam() {
        return team;
    }

    public void setTeam(PlayerTeamImportDto team) {
        this.team = team;
    }

    public PlayerStatImportDto getStatId() {
        return statId;
    }

    public void setId(PlayerStatImportDto statId) {
        this.statId = statId;
    }
}
