package softuni.exam.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "library_members")
public class LibraryMember extends BaseEntity {
    //•	first name - accepts char sequence (between 2 to 30 inclusive).
    //•	last name - accepts char sequence (between 2 to 30 inclusive).
    //•	address - accepts char sequence (between 2 to 40 inclusive). Can be nullable.
    //•	phone number - accepts char sequence (between 2 to 20 inclusive). The values are unique in the database.

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column
    private String address;

    @Column(unique = true, nullable = false, name = "phone_number")
    private String phoneNumber;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
