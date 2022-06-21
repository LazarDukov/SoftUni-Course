import com.sun.source.tree.ArrayAccessTree;

import java.lang.reflect.Array;
import java.util.*;
//Pear Sour	150
//The Harvest	250
//Apple Hinny	300
//High Fashion	400

public class oct23AutumnCoctails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ingredientsIn = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] freshnessIn = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        Map<String, Integer> cocktails = new TreeMap<>();
        cocktails.putIfAbsent("Pear Sour", 0);
        cocktails.putIfAbsent("The Harvest", 0);
        cocktails.putIfAbsent("Apple Hinny", 0);
        cocktails.putIfAbsent("High Fashion", 0);
        int ingredientsSum = 0;
        for (int i : ingredientsIn) {
            ingredients.add(i);
        }
        for (int i : freshnessIn) {
            freshness.push(i);
        }

        while (!(ingredients.isEmpty() || freshness.isEmpty())) {
            ingredientsSum = 0;
            if (ingredients.peek() == 0) {
                ingredients.poll();
                continue;
            }
            if (ingredients.peek() * freshness.peek() == 150) {
                cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                remove(ingredients, freshness);
            } else if (ingredients.peek() * freshness.peek() == 250) {
                cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                remove(ingredients, freshness);
            } else if (ingredients.peek() * freshness.peek() == 300) {
                cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                remove(ingredients, freshness);
            } else if (ingredients.peek() * freshness.peek() == 400) {
                cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                remove(ingredients, freshness);
            } else {
                freshness.pop();
                int newValueToAdd = ingredients.poll() + 5;
                ingredients.addLast(newValueToAdd);
            }


        }
        if (cocktails.get("Pear Sour") > 0
                && cocktails.get("The Harvest") > 0
                && cocktails.get("Apple Hinny") > 0
                && cocktails.get("High Fashion") > 0) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()) {
            ingredientsSum = 0;
            while (!ingredients.isEmpty()) {
                ingredientsSum += ingredients.poll();
            }
            System.out.println("Ingredients left: " + ingredientsSum);
        }
        for (var e : cocktails.entrySet()) {
            if (e.getValue() > 0) {
                System.out.printf(" # %s --> %d" + System.lineSeparator(), e.getKey(), e.getValue());
            }
        }
    }

    public static void remove(ArrayDeque<Integer> ingredients, ArrayDeque<Integer> freshness) {
        ingredients.poll();
        freshness.pop();
    }
}
