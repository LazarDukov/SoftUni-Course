package softuni.exam.models.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LibraryMemberImportDto {

    //{
    //    "address": "23 Einsteinufer str",
    //    "firstName": null,
    //    "lastName": "Schmidt",
    //    "phoneNumber": "525-22"
    //  }

    //---------------------------------------
    //•	id – accepts integer values, a primary identification field, an auto incremented field.
    //•	first name - accepts char sequence (between 2 to 30 inclusive).
    //•	last name - accepts char sequence (between 2 to 30 inclusive).
    //•	address - accepts char sequence (between 2 to 40 inclusive). Can be nullable.
    //•	phone number - accepts char sequence (between 2 to 20 inclusive). The values are unique in the database.
    @NotNull
    @Size(min = 2, max = 30)
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    private String lastName;

    @Size(min = 2, max = 40)
    private String address;

    @NotNull
    @Size(min = 2, max = 20)
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
