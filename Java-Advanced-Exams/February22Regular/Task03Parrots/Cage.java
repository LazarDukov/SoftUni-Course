package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Parrot> data = new ArrayList<>();

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(parrot -> parrot.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        for (var p : this.data) {
            if (p.getName().equals(name)) {
                p.setAvailable(false);
                return p;
            }
        }
        return null;
    }


    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrots = new ArrayList<>();
        for (Parrot p : this.data) {
            if (p.getSpecies().equals(species)) {
                parrots.add(p);
                p.setAvailable(false);
            }
        }
        return parrots;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        String firstRow = String.format("Parrots available at %s:" + System.lineSeparator(), this.name);
        return firstRow + this.data.stream().filter(Parrot::isAvailable).map(Parrot::toString).collect(Collectors.joining(System.lineSeparator()));

    }
}


//•	name: String
//•	capacity: int
//•	data: List<Parrot> that holds added parrots