package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private String name;
    private Dough dough;
    private List<Topping> toppings;

    //+ 	Piza (String, int numberOfToppings)
    //-	setToppings(int) : void
    //-	setName(String) : void
    //+	setDough(Dough) : void
    //+	getName(): String
    //+	addTopping (Topping) : void
    //+	getOverallCalories () : double


    public Pizza(String name, int numbersOfToppings) {
        setName(name);
        setToppings(numbersOfToppings);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getOverallCalories() {
        return dough.calculateCalories() + toppings.stream().mapToDouble(Topping::calculateCalories).sum();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.trim().isEmpty() || name.length() < 1 || name.length() > 15) {
            throw new IllegalArgumentException(ExceptionMesseges.EMPTY_OR_LONGER_THAN_15_SYMBOLS);
        }
        this.name = name;
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public void setToppings(int numbersOfToppings) {
        if (numbersOfToppings >= 10 || numbersOfToppings < 0) {
            throw new IllegalArgumentException(ExceptionMesseges.TOPPINGS_NUMBER_OUTSIDE_OF_RANGE);
        }
        this.toppings = new ArrayList<>(numbersOfToppings);
    }
}
