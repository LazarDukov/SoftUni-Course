import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class e11t2SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    //    int[] arr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    //    int sum = Arrays.stream(arr).sum();
    //    double count = Arrays.stream(arr).count();
    //    System.out.printf("Count = %.0f%n", count);
    //    System.out.println("Sum = " + sum);



        String[] input = scanner.nextLine().split(", ");
        Function<String[], String> stringFormatter = list -> "Count = " + list.length;
        String outputCount = stringFormatter.apply(input);
        Function<String[], Integer> sumFormatter = l-> Arrays.stream(l).mapToInt(Integer::parseInt).sum();
        String outputSum = sumFormatter.apply(input).toString();

        System.out.println(outputCount);
        System.out.println("Sum = " + outputSum);
    }
}
