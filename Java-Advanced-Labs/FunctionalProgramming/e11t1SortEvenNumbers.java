import java.util.*;
import java.util.stream.Collectors;

public class e11t1SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());


        String toPrint = numbers.stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(toPrint);
        System.out.println(numbers.stream().sorted().map(String::valueOf).collect(Collectors.joining(", ")));
    }
}
