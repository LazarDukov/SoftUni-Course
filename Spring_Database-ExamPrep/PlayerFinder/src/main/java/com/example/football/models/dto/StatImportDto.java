package com.example.football.models.dto;


import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatImportDto {

    @XmlElement
    @Positive
    private float shooting;
    @XmlElement
    @Positive
    private float passing;
    @XmlElement
    @Positive
    private float endurance;

    public StatImportDto() {
    }

    public StatImportDto(float shooting, float passing, float endurance) {
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

    public String toString() {
        return String.format(passing + " - " + shooting + " - " + endurance);
    }
}
