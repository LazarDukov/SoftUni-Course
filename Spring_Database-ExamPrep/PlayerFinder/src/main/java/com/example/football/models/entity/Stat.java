package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity
@Table(name = "stats")
public class Stat extends BaseEntity {
    //•	shooting – a floating point number. The value must be positive (larger than 0).
    //•	passing – a floating point number. The value must be positive (larger than 0).
    //•	endurance – a floating point number. The value must be positive (larger than 0).

    @Column(nullable = false)
    @Min(0)
    private float shooting;

    @Column(nullable = false)
    @Min(0)
    private float passing;

    @Column(nullable = false)
    @Min(0)
    private float endurance;

    public Stat() {
    }

    public Stat(float shooting, float passing, float endurance) {
        this.shooting = shooting;
        this.passing = passing;
        this.endurance = endurance;
    }

    public float getShooting() {
        return shooting;
    }

    public void setShooting(float shooting) {
        this.shooting = shooting;
    }

    public float getPassing() {
        return passing;
    }

    public void setPassing(float passing) {
        this.passing = passing;
    }

    public float getEndurance() {
        return endurance;
    }

    public void setEndurance(float endurance) {
        this.endurance = endurance;
    }
}
