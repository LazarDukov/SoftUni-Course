package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {
//•	id – accepts integer values, a primary identification field, an auto incremented field.
//•	name – accepts char sequences as values where their character length value higher than or equal to 2. The values are unique in the database.
//•	population – accepts number values (must be a positive number), 0 as a value is exclusive.
//•	travel guide – a long and detailed description of all known places with a character length value higher than or equal to 10.

    @Column(unique = true, nullable = false)
    @Size(min = 2)
    private String name;

    @Column(nullable = false)
    @Min(1)
    private int population;

    @Column(name = "travel_guide", columnDefinition = "TEXT",nullable = false)
    @Size(min = 10)
    private String description;


    public Town() {
    }

    public Town(String name, int population, String description) {
        this.name = name;
        this.population = population;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
