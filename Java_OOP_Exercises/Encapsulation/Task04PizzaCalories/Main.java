package pizzaCalories;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //•	On the first line is the pizza name and the number of toppings it has in the format:
        //Pizza {pizzaName} {numberOfToppings}
        //•	On the second line you will get input for the dough in the format:
        //Dough {flourType} {bakingTechnique} {weightInGrams}
        //•	On the next lines, you will receive every topping the pizza has, until an"END" command is given:
        //Topping {toppingType} {weightInGrams}
        Scanner scanner = new Scanner(System.in);
        String[] pizza = scanner.nextLine().split("\\s+");
        String pizzaName = pizza[1];
        int numberOfToppings = Integer.parseInt(pizza[2]);
        Pizza newPizza = new Pizza(pizzaName, Integer.parseInt(pizza[2]));
        String[] flourInstructions = scanner.nextLine().split("\\s+");
        String flourType = flourInstructions[1];
        String bakingTechnique = flourInstructions[2];
        double flourWeight = Double.parseDouble(flourInstructions[3]);
        Dough dough = new Dough(flourType, bakingTechnique, flourWeight);
        newPizza.setDough(dough);
        String[] toppingInstructions = scanner.nextLine().split("\\s+");
        while (!"END".equals(toppingInstructions[0])) {
            String toppingType = toppingInstructions[1];
            double toppingWeight = Double.parseDouble(toppingInstructions[2]);
            Topping topping = new Topping(toppingType, toppingWeight);
            newPizza.addTopping(topping);
            toppingInstructions = scanner.nextLine().split("\\s+");

        }
        System.out.printf("%s - %.2f", pizzaName, newPizza.getOverallCalories());
    }
}
