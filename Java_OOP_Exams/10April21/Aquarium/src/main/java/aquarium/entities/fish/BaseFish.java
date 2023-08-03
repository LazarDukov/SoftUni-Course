package aquarium.entities.fish;

import static aquarium.common.ExceptionMessages.*;

public abstract class BaseFish implements Fish {
    //•	name - String
    //o	If the name is null or whitespace, throw a NullPointerException with a message:
    //"Fish name cannot be null or empty."
    //o	All names are unique.
    //•	species -  String
    //o	If the species is null or whitespace, throw a NullPointerException with a message:
    //"Fish species cannot be null or empty."
    //•	size -  int
    //o	The size of the Fish.
    //•	price - double
    //o	The price of the Fish.
    //o	If the price is below or equal to 0, throw an IllegalArgumentException with a message:
    // "Fish price cannot be below or equal to 0."
    private String name;
    private String species;
    private int size;
    private double price;

    public BaseFish(String name, String species, double price) {
        setName(name);
        setSpecies(species);
        setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name.trim().isEmpty() || name == null) {
            throw new NullPointerException(FISH_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        if (species.trim().isEmpty() || species == null) {
            throw new NullPointerException(SPECIES_NAME_NULL_OR_EMPTY);
        }
        this.species = species;
    }

    @Override
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(FISH_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }

    @Override
    public void eat() {
        size += 5;
    }
}
