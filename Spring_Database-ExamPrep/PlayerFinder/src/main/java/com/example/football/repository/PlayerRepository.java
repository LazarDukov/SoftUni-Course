package com.example.football.repository;

import com.example.football.models.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByEmail(String email);

    //•	Order Them by Shooting in Desc Order, Then by Passing in Desc Order, Then by Endurance Desc Order and Finally Then by Player Last Name.
    //•	Extract from the database, the first name, last name, position, team name and the name of the stadium of the team.
    //•	Select only players with birth date after 01-01-1995 and before 01-01-2003
    //•	Return the information in this format:
    //"Player - {firstName} {lastName}
    //	Position - {position name}

    List<Player> findByBirthDateBetweenOrderByStatShootingDescStatPassingDescStatEnduranceDescLastNameAsc(LocalDate after, LocalDate before);
}
