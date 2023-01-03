package softuni.exam.models.entity;


import org.w3c.dom.Text;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "cities")
public class City extends BaseEntity {

    @Column(name = "city_name", nullable = false, unique = true)
    @Size(min = 2, max = 60)
    private String cityName;

    @Column(columnDefinition = "TEXT")
    @Size(min = 2)
    private String description;

    @Column(nullable = false)
    private Long population;

    @ManyToOne
    private Country country;

    @OneToMany(targetEntity = Forecast.class, mappedBy = "city")
    private List<Forecast> forecastList;

    public String toString() {
        return String.format(this.cityName + " - " + this.population);
    }

    public City() {
    }

    public City(String cityName, String description, Long population, Country country, List<Forecast> forecastList) {
        this.cityName = cityName;
        this.description = description;
        this.population = population;
        this.country = country;
        this.forecastList = forecastList;
    }

    public String getCityName() {
        return cityName;
    }

    public void setName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Forecast> getForecastList() {
        return forecastList;
    }

    public void setForecastList(List<Forecast> forecastList) {
        this.forecastList = forecastList;
    }

}
