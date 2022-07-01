import java.util.Scanner;

public class Lab_Task01Rhombus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printUpperSide(n);
        printBottomSide(n);
    }

    public static void printUpperSide(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    public static void printBottomSide(int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
