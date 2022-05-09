import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> decimal = new ArrayDeque<>();
        if (number == 0) {
            System.out.println("0");
        }
        while (number >= 1) {

            int left = number % 2;
            number /= 2;
            decimal.push(left);
        }
        for (Integer ch:decimal ) {
            System.out.print(ch);
        }
    }
}
