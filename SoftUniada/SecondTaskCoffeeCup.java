import java.util.Locale;
import java.util.Scanner;

public class SecondTaskCoffeeCup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String text = scanner.nextLine();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" ");
            }
            System.out.print("~ ~ ~");
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                for (int j = 0; j < 3 * n + 5; j++) {
                    System.out.print("=");
                }
                System.out.println();
            }
            if (i > 0 && i < n - 1) {
                System.out.print("|");
                if (n / 2 == i) {
                    for (int j = 0; j < n; j++) {
                        System.out.print("~");
                    }
                    System.out.print(text.toUpperCase(Locale.ROOT));
                    for (int j = 0; j < n; j++) {
                        System.out.print("~");
                    }
                } else {
                    for (int j = 0; j < n; j++) {
                        System.out.print("~");
                    }
                    for (int j = 0; j < text.length(); j++) {
                        System.out.print("~");
                    }
                    for (int j = 0; j < n; j++) {
                        System.out.print("~");
                    }
                }
                System.out.print("|");
                for (int j = 0; j < n - 1; j++) {
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.println();
            }
            if (i == n - 1) {
                for (int j = 0; j < 3 * n + 5; j++) {
                    System.out.print("=");
                }
                System.out.println();
            }
        }
        int countForCliomba = 6 + (n - 1) * 2;
        int spaceCounter = 0;
        for (int i = 0; i < n; i++) {
            for (int k = countForCliomba; k > 0; k--) {
                if (k == countForCliomba) {
                    for (int j = 0; j < spaceCounter; j++) {
                        System.out.print(" ");
                    }
                    System.out.print("\\");
                }
                System.out.print("@");
                if (k == 1) {
                    System.out.print("/");
                }
            }
            System.out.println();
            spaceCounter++;
            countForCliomba -= 2;

        }
        for (int j = 0; j < 3 * n + 5; j++) {
            System.out.print("-");
        }
    }
}
