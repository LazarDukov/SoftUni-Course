package SortByNameAndAge;

public class Person {
    //•	firstName: String
    //•	lastName: String
    //•	age: int
    //•	toString() - override
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return String.format("%s %s is %d years old.", this.firstName, this.lastName, this.age);

    }
    //Angel Harizanov is 44 years old.
    //Angel Ivanov is 65 years old.
    //Boris Angelov is 35 years old.
    //Boris Georgiev is 57 years old.
    //Veny Ivanov is 27 years old.
}
