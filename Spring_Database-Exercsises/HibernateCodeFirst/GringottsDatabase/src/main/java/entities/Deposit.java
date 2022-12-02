package entities;




import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, name = "deposit_group")
    private String group;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column
    private Double amount;

    @Column
    private Double interest;

    @Column
    private Double charge;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "expired")
    private Boolean isExpired;

    public Deposit() {
    }

    public Deposit(Long id, String group, LocalDate startDate, Double amount, Double interest, Double charge, LocalDate expirationDate, Boolean isExpired) {
        this.id = id;
        this.group = group;
        this.startDate = startDate;
        this.amount = amount;
        this.interest = interest;
        this.charge = charge;
        this.expirationDate = expirationDate;
        this.isExpired = isExpired;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }
}
