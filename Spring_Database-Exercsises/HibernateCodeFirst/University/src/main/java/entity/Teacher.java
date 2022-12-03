package entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends BasePerson {

    //•	Teacher (id, first name, last name, phone number, email, salary per hour)

    @Column
    private String email;

    @Column(name = "salary_per_hour")
    private Double salaryPerHour;

    @OneToMany(mappedBy = "teacher")
    private Set<Course> courses;

    public Teacher() {
        super();
        courses = new HashSet<>();
    }

    public Teacher(String firstName, String lastName, String phoneNumber, String email, Double salaryPerHour, Set<Course> courses) {
        super(firstName, lastName, phoneNumber);
        this.email = email;
        this.salaryPerHour = salaryPerHour;
        courses = new HashSet<>();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(Double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
