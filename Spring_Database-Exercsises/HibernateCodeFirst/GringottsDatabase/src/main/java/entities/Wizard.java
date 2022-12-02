package entities;


import javax.persistence.*;
import java.util.List;


@Entity
@Table
public class Wizard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, name = "first_name")
    private String firstName;

    @Column(length = 60, name = "last_name", nullable = false)
    private String lastName;

    @Column(length = 1000)
    private String notes;

    @Column(nullable = false)
    private Long age;

    @OneToOne
    @JoinColumn(name = "magic_wand")
            private MagicWand magicWand;

            @OneToMany
            @JoinTable(name = "wizard_deposits",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "deposit_id")
    )
    private List<Deposit> deposits;

    public Wizard() {
    }

    public Wizard(Long id, String firstName, String lastName, String notes, Long age, MagicWand magicWand, List<Deposit> deposits) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.notes = notes;
        this.age = age;
        this.magicWand = magicWand;
        this.deposits = deposits;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public MagicWand getMagicWand() {
        return magicWand;
    }

    public void setMagicWand(MagicWand magicWand) {
        this.magicWand = magicWand;
    }

    public List<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Deposit> deposits) {
        this.deposits = deposits;
    }
}
