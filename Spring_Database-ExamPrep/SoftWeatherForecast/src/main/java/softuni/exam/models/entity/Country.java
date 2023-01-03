package softuni.exam.models.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity {


    @Column(name = "country_name", unique = true, nullable = false)
    @Size(min = 2, max = 60)
    private String name;

    @Column
    @Size(min = 2, max = 20)
    private String currency;

    public String toString() {
        return String.format(this.name + " - " + this.currency);
    }


    public Country() {
    }

    public Country(String name, String currency) {
        this.name = name;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
