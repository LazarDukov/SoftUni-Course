import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class e12t4AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        UnaryOperator<List<Integer>> addNumbers = list -> list.stream().map(el -> el + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiplyNumbers = list -> list.stream().map(el -> el * 2).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtractNumbers = list -> list.stream().map(el -> el - 1).collect(Collectors.toList());

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    arr = addNumbers.apply(arr);
                    break;
                case "multiply":
                    arr = multiplyNumbers.apply(arr);
                    break;
                case "subtract":
                    arr = subtractNumbers.apply(arr);
                    break;
                case "print":
                    arr.forEach(el -> System.out.printf("%d ", el));
                    System.out.println();
                    break;

            }
            command = scanner.nextLine();
        }

    }

}
