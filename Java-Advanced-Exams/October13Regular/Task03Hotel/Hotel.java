package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    //•	name: String
    //•	capacity: int
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    // Method add(Person person) - adds an entity to the roster if there is room for it
    public void add(Person person) {
        if (this.roster.size() < this.capacity) {
            roster.add(person);
        }

    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Person> getRoster() {
        return roster;
    }


    //   Method remove(String name) - removes a person by given name, if such exists, and returns boolean
    public boolean remove(String name) {
        for (Person p : roster) {
            if (p.getName().equals(name)) {
                this.roster.remove(p);
                return true;
            }
        }
        return false;

    }
    //•	Method getPerson(String name, String hometown) – returns the people with the given name and hometown or null if there is no such person.

    public Person getPerson(String name, String hometown) {
        Person person = null;
        for (Person p : roster) {
            if (p.getName().equals(name) && p.getHometown().equals(hometown)) {
                person = p;
            }
        }
        return person;
    }


    // •	Getter getCount() – returns the number of people.
    public int getCount() {
        return this.roster.size();
    }

    // •	getStatistics() – returns a String in the following format:

    public String getStatistics() {
        String toPrint = String.format("The people in the hotel %s are:%n", this.name);
        return toPrint + this.roster.stream().map(Person::toString).collect(Collectors.joining(System.lineSeparator()));

    }



    //"The people in the hotel {name} are:
    //{Person1}
    //{Person2}
    //(…)"
}