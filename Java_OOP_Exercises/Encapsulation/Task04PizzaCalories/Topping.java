package pizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public String getToppingType() {
        return toppingType;
    }

    public void setToppingType(String toppingType) {
        if (!(toppingType.equals("Meat") || toppingType.equals("Cheese") || toppingType.equals("Sauce") || toppingType.equals("Veggies"))) {
            throw new IllegalArgumentException(String.format(ExceptionMesseges.TOPPING_DIFFERENT_TYPE, toppingType));
        }
        this.toppingType = toppingType;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format(ExceptionMesseges.TOPPING_WEIGHT_OUTSIDE_OF_RANGE, this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {

        return 2 * weight * ToppingModifier.calories.get(toppingType);
    }
}
