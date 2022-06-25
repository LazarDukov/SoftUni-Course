import java.util.*;

public class june25Chocolate {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        double[] milkQuantityInput = Arrays.stream(cs.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        double[] cacaoQuantityInput = Arrays.stream(cs.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        ArrayDeque<Double> milkQuantity = new ArrayDeque<>();//queue
        ArrayDeque<Double> cacaoQuantity = new ArrayDeque<>();//stack
        for (Double m : milkQuantityInput) {
            milkQuantity.add(m);
        }
        for (Double c : cacaoQuantityInput) {
            cacaoQuantity.push(c);
        }

        Map<String, Integer> types = new TreeMap<>();
        types.put("Milk Chocolate", 0);
        types.put("Dark Chocolate", 0);
        types.put("Baking Chocolate", 0);
        while (!(milkQuantity.isEmpty() || cacaoQuantity.isEmpty())) {
            double cacaoPercentage = (cacaoQuantity.peek() / (milkQuantity.peek() + cacaoQuantity.peek())) * 100;
            if (cacaoPercentage == 30) {
                milkQuantity.poll();
                cacaoQuantity.pop();
                types.put("Milk Chocolate", types.get("Milk Chocolate") + 1);
            } else if (cacaoPercentage == 50) {
                milkQuantity.poll();
                cacaoQuantity.pop();
                types.put("Dark Chocolate", types.get("Dark Chocolate") + 1);
            } else if (cacaoPercentage == 100) {
                milkQuantity.poll();
                cacaoQuantity.pop();
                types.put("Baking Chocolate", types.get("Baking Chocolate") + 1);
            } else {
                cacaoQuantity.pop();
                double increasedValue = milkQuantity.poll() + 10;
                milkQuantity.add(increasedValue);
            }
        }
        if (types.get("Milk Chocolate") > 0 && types.get("Dark Chocolate") > 0 && types.get("Baking Chocolate") > 0) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        for (var chocolate : types.entrySet()) {
            if (chocolate.getValue() > 0) {
                System.out.printf(" # %s --> %d" + System.lineSeparator(), chocolate.getKey(), chocolate.getValue());
            }
        }
    }
}
//Chocolate types	Cacao percentage
//Milk Chocolate	30
//Dark Chocolate	50
//Baking Chocolate	100