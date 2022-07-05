package CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.printf("%s:%n", input);
        for (CardRank c : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", c.getValue(), c);
        }
    }
}
