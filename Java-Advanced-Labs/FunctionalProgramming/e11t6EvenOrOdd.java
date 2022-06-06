import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class e11t6EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int down = input[0];
        int up = input[1];
        String evenOrOdd = scanner.nextLine();
        System.out.print(IntStream.rangeClosed(down, up)
                .mapToObj(Integer::valueOf)
                .filter(filterMethod(down, up, evenOrOdd))
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));


    }
    public static Predicate<Integer> filterMethod(int down, int up, String evenOrOdd) {
        if (evenOrOdd.equals("even")) {
            return el -> el%2==0;
        } else if (evenOrOdd.equals("odd")){
return el -> el%2!=0;
        } else {
                throw new IllegalArgumentException("Unknown command");
        }

    }
}
