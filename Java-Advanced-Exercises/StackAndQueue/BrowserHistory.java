import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> deck = new ArrayDeque<>();
        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (deck.size()<=1) {
                    System.out.println("no previous URLs");
                } else {
                    deck.pop();
                    System.out.println(deck.peek());
                }
            } else {
                deck.push(input);
                System.out.println(deck.peek());
            }
            input = scanner.nextLine();
        }

    }
}
