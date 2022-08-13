package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.BaseToy;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_CAT;
import static catHouse.common.ExceptionMessages.HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY;

public abstract class BaseHouse implements House {

    //•	name - String
//o	If the name is null or whitespace, throw a NullPointerException with a message:
//"House name cannot be null or empty."
//o	All names are unique.
//•	capacity -  int
//o	The number of Cat аn House can have.
//•	toys - Collection<Toy>
//•	cats - Collection<Cat>

    private String name;
    private int capacity;
    private Collection<Toy> toys;
    private Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (capacity > cats.size()) {
            cats.add(cat);
        } else {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
    }

    @Override
    public void removeCat(Cat cat) {
        cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.stream().forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        return name + " " + getClass().getSimpleName() + ":" + System.lineSeparator() +
                "Cats: " + (cats.size() == 0 ? "none" : cats.stream().map(Cat::getName).collect(Collectors.joining(" "))) + System.lineSeparator() +
                "Toys: " + toys.size() + " Softness: " + sumSoftness();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
    }

    @Override
    public Collection<Cat> getCats() {
        return cats;
    }

    @Override
    public Collection<Toy> getToys() {
        return toys;
    }
}
