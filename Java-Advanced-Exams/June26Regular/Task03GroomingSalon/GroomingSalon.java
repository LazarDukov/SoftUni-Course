package groomingSalon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    //•	Field data – List that holds added pets
    //•	Method add(Pet pet) – adds an entity to the data if there is an empty place in the grooming salon for the pet.
    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    //•	Method remove(String name) – removes the pet by given name, if such exists, and returns boolean.
    public boolean remove(String name) {
        return this.data.removeIf(pet -> pet.getName().equals(name));
    }

    //•	Method getPet(String name, String owner) – returns the pet with the given name and owner or null if no such pet exists.
    public Pet getPet(String name, String owner) {
        Pet pet = null;
        for (Pet p : this.data) {
            if (p.getName().equals(name) && p.getOwner().equals(owner)) {
                pet = p;
            }
        }
        return pet;
    }

    //•	Getter getCount – returns the number of pets.

    public int getCount() {
        return this.data.size();
    }


    //    •	getStatistics() – returns a String in the following format:
//    o	" The grooming salon has the following clients:
//    {name} {owner}
//    {name} {owner}
//   (…)"
    public String getStatistics() {
        return " The grooming salon has the following clients:" + System.lineSeparator() +
                this.data.stream().map(pet -> pet.getName() + " " + pet.getOwner()).collect(Collectors.joining(System.lineSeparator()));
    }

}
