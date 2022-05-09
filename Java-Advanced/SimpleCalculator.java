import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> deck = new ArrayDeque<>();
        Collections.addAll(deck, input);
        while (deck.size() > 1) {
            int firstNumber = Integer.parseInt(deck.pop());
            String operator = deck.pop();
            int secondNumber = Integer.parseInt(deck.pop());
            int result = 0;
            if (operator.equals("+")) {
                result = firstNumber + secondNumber;
            } else {
                result = firstNumber-secondNumber;
            }
            deck.push(String.valueOf(result));
        }
        for (String s : deck) {
            System.out.println(s);
        }
    }
}
