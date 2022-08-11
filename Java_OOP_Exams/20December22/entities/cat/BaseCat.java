package catHouse.entities.cat;

import static catHouse.common.ExceptionMessages.*;

public abstract class BaseCat implements Cat {
    //•	name - String
    //o	If the name is null or whitespace, throw a NullPointerException with a message:
    //"Cat name cannot be null or empty."
    //o	All names are unique.
    //•	breed -  String
    //o	If the breed is null or whitespace, throw a NullPointerException with a message:
    //"Cat breed cannot be null or empty."
    //•	kilograms -  int
    //o	The kilograms of the Cat.
    //•	price - double
    //o	The price of the Cat.
    //o	If the price is below or equal to 0, throw an IllegalArgumentException with a message:
    // "Cat price cannot be below or equal to 0."

    private String name;
    private String breed;
    private int kilograms;
    private double price;

    public BaseCat(String name, String breed, double price) {
        setName(name);
        setBreed(breed);
        setPrice(price);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(CAT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            throw new NullPointerException(CAT_BREED_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.breed = breed;
    }

    @Override
    public int getKilograms() {
        return kilograms;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(CAT_PRICE_CANNOT_BE_BELOW_OR_EQUAL_TO_ZERO);
        }
        this.price = price;
    }

    public void setKilograms(int kilograms) {
        this.kilograms = kilograms;
    }
}
