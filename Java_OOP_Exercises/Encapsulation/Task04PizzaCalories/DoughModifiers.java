package pizzaCalories;

import java.util.Map;

public class DoughModifiers {
    public static final Map<String, Double> caloriesOfFlour =
            Map.of("White", 1.5,
                    "Wholegrain", 1.0);
    public static final Map<String, Double> caloriesOfBaking =
            Map.of("Crispy", 0.9,
                    "Chewy", 1.1,
                    "Homemade", 1.0);

}
