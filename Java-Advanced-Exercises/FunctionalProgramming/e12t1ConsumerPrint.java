import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class e12t1ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> line = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        line.forEach(s -> System.out.println(s));

    }
}
