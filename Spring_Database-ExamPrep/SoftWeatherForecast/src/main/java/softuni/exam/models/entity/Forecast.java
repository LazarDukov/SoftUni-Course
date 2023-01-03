package softuni.exam.models.entity;

import softuni.exam.util.WeekDays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalTime;

@Entity
@Table(name = "forecasts")
public class Forecast extends BaseEntity {


    //•	id – accepts integer values, a primary identification field, an auto incremented field.
    //•	day of week – enumerated value, one of the following – FRIDAY, SATURDAY, SUNDAY. Cannot be null.
    //•	max temperature – a floating point number. Must be between -20 and 60 (both numbers are INCLUSIVE). Cannot be null.
    //•	min temperature – a floating point number. Must be between -50 and 40 (both numbers are INCLUSIVE). Cannot be null.
    //•	sunrise – time of the sunrise. Cannot be null.
    //•	sunset – time of the sunset. Cannot be null.
    //•	Constraint: The forecasts table has а relation with the cities table.


    @Column(name = "day_of_week", nullable = false)
    private WeekDays weekDays;

    @Column(nullable = false)
    @Min(-20)
    @Max(60)
    private double maxTemperature;


    @Column(nullable = false)
    @Min(-50)
    @Max(40)
    private double minTemperature;

    @Column(nullable = false)
    private LocalTime sunrise;


    @Column(nullable = false)
    private LocalTime sunset;

    @ManyToOne
    private City city;


    public Forecast() {
    }

    public Forecast(WeekDays weekDays, Double maxTemperature, Double mixTemperature, LocalTime sunrise, LocalTime sunset, City city) {
        this.weekDays = weekDays;
        this.maxTemperature = maxTemperature;
        this.minTemperature = mixTemperature;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.city = city;
    }
    public String toString() {
        return String.format("City: %s:\n" +
                        "\t-min temperature: %.2f\n" +
                        "\t--max temperature: %.2f\n" +
                        "\t---sunrise: %s\n" +
                        "\t----sunset: %s",
                this.city.getCityName(),
                this.minTemperature,
                this.maxTemperature,
                this.sunrise,
                this.sunset);
    }

    public WeekDays getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(WeekDays weekDays) {
        this.weekDays = weekDays;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public LocalTime getSunrise() {
        return sunrise;
    }

    public void setSunrise(LocalTime sunrise) {
        this.sunrise = sunrise;
    }

    public LocalTime getSunset() {
        return sunset;
    }

    public void setSunset(LocalTime sunset) {
        this.sunset = sunset;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


}
