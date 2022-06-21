package easterBasket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.data = new ArrayList<>();
        this.material = material;
        this.capacity = capacity;
    }

    //•	Method addEgg(Egg egg) – adds an entity to the data if there is room for it
    public void addEgg(Egg egg) {
        if (this.data.size() < this.capacity) {
            this.data.add(egg);
        }
    }

    //•	Method removeEgg(string color) – removes an egg by given color,
    // if such exists, and returns boolean (true if it is removed, otherwise – false)
    public boolean removeEgg(String color) {
        return this.data.removeIf(egg -> egg.getColor().equals(color));
    }

    //•	Method getStrongestEgg()– returns the strongest egg
    public Egg getStrongestEgg() {
        return this.data.stream().max(Comparator.comparing(Egg::getStrength)).orElse(null);
    }

    //•	Method getEgg(string color) – returns the egg with the given color
    public Egg getEgg(String color) {
        return this.data.stream().filter(egg -> egg.getColor().equals(color)).findAny().orElse(null);

    }

    //•	Method getCount – returns the number of eggs
    public int getCount() {
        return this.data.size();
    }

    //•	Method report() – returns a string in the following format (print the eggs in order of appearance):
    //o	"{material} basket contains:
    //{Egg1}
    //{Egg2}
    //(…)"
    public String report() {
        return String.format("%s basket contains:" + System.lineSeparator() +
                this.data.stream().map(Egg::toString).collect(Collectors.joining(System.lineSeparator())), this.material);
    }
}
