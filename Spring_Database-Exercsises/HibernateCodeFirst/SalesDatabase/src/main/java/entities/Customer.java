package entities;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    //•	customer (id, name, email, credit_card_number)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column(name = "credit_card_number")
    private String creditCardNumber;

    public Customer() {
    }

    public Customer(Long id, String name, String email, String creditCardNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.creditCardNumber = creditCardNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
