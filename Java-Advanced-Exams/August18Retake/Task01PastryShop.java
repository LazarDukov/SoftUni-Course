import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class pastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] liquidsInputData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] ingredientsInputData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        for (Integer i : liquidsInputData) {
            liquids.add(i);
        }
        for (Integer i : ingredientsInputData) {
            ingredients.push(i);
        }
        int biscuit = 0;
        int cake = 0;
        int pastry = 0;
        int pie = 0;

        while (!(liquids.isEmpty() || ingredients.isEmpty())) {
            switch (liquids.peek() + ingredients.peek()) {
                case 25:
                    liquids.poll();
                    ingredients.pop();
                    biscuit++;
                    break;
                case 50:
                    liquids.poll();
                    ingredients.pop();
                    cake++;
                    break;
                case 75:
                    liquids.poll();
                    ingredients.pop();
                    pastry++;
                    break;
                case 100:
                    liquids.poll();
                    ingredients.pop();
                    pie++;
                    break;
                default:
                    liquids.poll();
                    ingredients.push(ingredients.pop() + 3);
                    break;
            }
        }
        if (biscuit > 0 && cake > 0 && pie > 0 && pastry > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.print("Liquids left: " + liquids.stream().map(Object::toString).collect(Collectors.joining(", ")) + System.lineSeparator());

        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.print("Ingredients left: " + ingredients.stream().map(Object::toString).collect(Collectors.joining(", ")) + System.lineSeparator());


        }
        System.out.printf("Biscuit: %d" + System.lineSeparator() +
                "Cake: %d" + System.lineSeparator() +
                "Pie: %d" + System.lineSeparator() +
                "Pastry: %d", biscuit, cake, pie, pastry);

    }
}
