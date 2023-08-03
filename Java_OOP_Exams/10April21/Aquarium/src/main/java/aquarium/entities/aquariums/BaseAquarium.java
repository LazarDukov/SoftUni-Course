package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium {
    //•	name - String
    //o	If the name is null or whitespace, throw a NullPointerException with a message:
    //"Aquarium name cannot be null or empty."
    //o	All names are unique.
    //•	capacity -  int
    //o	The number of Fish аn Aquarium can have.
    //•	decorations - Collection<Decoration>
    //•	fish - Collection<Fish>

    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        setName(name);
        setCapacity(capacity);
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public void addFish(Fish fish) {
        if (this.fish.size() == this.capacity) {

            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }
        this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        //Returns a String with information about the Aquarium in the format below. If the Aquarium doesn't have fish, print "none" instead.
        //"{aquariumName} ({aquariumType}):
        //Fish: {fishName1} {fishName2} {fishName3} (…) / Fish: none
        //Decorations: {decorationsCount}
        //Comfort: {aquariumComfort}"
        return String.format("%s (%s):", name, getClass().getSimpleName()) + System.lineSeparator() +
                String.format("Fish: %s",
                        (fish.size() == 0 ?
                                "none" :
                                fish.stream().map(Fish::getName).collect(Collectors.joining(" ")))) + System.lineSeparator() +
                String.format("Decorations: %d", decorations.size()) + System.lineSeparator() +
                String.format("Comfort: %d", calculateComfort());
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
