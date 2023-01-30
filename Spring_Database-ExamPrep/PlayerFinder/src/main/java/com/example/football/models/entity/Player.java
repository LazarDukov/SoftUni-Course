package com.example.football.models.entity;

import com.example.football.util.Position;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    //•	first name – accepts char sequences as values where their character length value higher than 2.
    //•	last name – accepts char sequences as values where their character length value higher than 2.
    //•	email – accepts valid email addresses (must contains '@' and '.' – a dot). The values are unique in the database.
    //•	birth date – a date in the "dd/MM/yyyy" format.
    //•	position – one of the following – ATT, MID, DEF.
    //o	Note: The players table has relations with the towns, teams and stats tables.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")

    private String firstName;

    @Column(name = "last_name")

    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column
    private Position position;

    @OneToOne
    private Stat stat;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Town town;

    public Player() {
    }

    public Player(String firstName, String lastName, String email, LocalDate birthDate, Position position, Stat stat, Team team, Town town) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
        this.position = position;
        this.stat = stat;
        this.team = team;
        this.town = town;
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

    public Stat getStat() {
        return stat;
    }

    public void setStat(Stat stat) {
        this.stat = stat;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && Objects.equals(email, player.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }

    public String toString() {
        //"Player - {firstName} {lastName}
        //	Position - {position name}
        //Team - {team name}
        //	Stadium - {stadium name}
        //. . . "
        return String.format("Player - %s %s%n" +
                "\tPosition - %s%n" +
                "Team - %s%n" +
                "\tStadium - %s", this.firstName, this.lastName, this.position, this.team.getName(), this.team.getStadiumName());
    }
}
