package pizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public String getFlourType() {
        return flourType;
    }

    public void setFlourType(String flourType) {
        if (!(flourType.equals("White") ||
                flourType.equals("Wholegrain"))) {
            throw new IllegalArgumentException(ExceptionMesseges.INVALID_TYPE_OF_DOUGH);
        }
        this.flourType = flourType;
    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    public void setBakingTechnique(String bakingTechnique) {
        if (!(bakingTechnique.equals("Crispy") ||
                bakingTechnique.equals("Chewy") ||
                bakingTechnique.equals("Homemade"))) {
            throw new IllegalArgumentException(ExceptionMesseges.INVALID_TYPE_OF_DOUGH);
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException(ExceptionMesseges.OUT_OF_RANGE);
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return 2 * weight * DoughModifiers.caloriesOfFlour.get(flourType) * DoughModifiers.caloriesOfBaking.get(bakingTechnique);
    }
}
