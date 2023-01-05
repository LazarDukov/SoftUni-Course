package com.example.football.models.entity;

import com.example.football.util.Position;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "players")
public class Player extends BaseEntity {

    //•	first name – accepts char sequences as values where their character length value higher than 2.
    //•	last name – accepts char sequences as values where their character length value higher than 2.
    //•	email – accepts valid email addresses (must contains '@' and '.' – a dot). The values are unique in the database.
    //•	birth date – a date in the "dd/MM/yyyy" format.
    //•	position – one of the following – ATT, MID, DEF.
    //o	Note: The players table has relations with the towns, teams and stats tables.

    @Column(name = "first_name", unique = true, nullable = false)
    @Size(min = 2)
    private String firstName;

    @Column(name = "last_name", unique = true, nullable = false)
    @Size(min = 2)
    private String lastName;

    @Email
    @NotNull
    @UniqueElements
    private String email;

    @Column(name = "birth_date", nullable = false)
    private Date birthDate;

    @Enumerated
    @NotNull
    private Position position;

    @OneToOne
    private Stat stat;

    @ManyToOne
    private Team team;

    @ManyToOne
    private Town town;

    public Player() {
    }

    public Player(String firstName, String lastName, String email, Date birthDate, Position position, Stat stat, Team team, Town town) {
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
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
}
