import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class e12t3CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Function<int[], Integer> number = (int[] newNumbers) -> {

            int min = Integer.MAX_VALUE;
            for (int n : numbers) {
                if (n < min) {
                    min = n;
                }
            }
            return min;
        };
        System.out.println(number.apply(numbers));
    }
}
