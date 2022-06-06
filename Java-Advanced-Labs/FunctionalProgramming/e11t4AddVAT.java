import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class e11t4AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> list = Arrays.stream(scanner.nextLine().split(", ")).map(Double::parseDouble).collect(Collectors.toList());
        UnaryOperator<Double> vatAdded = d -> d * 1.20;
        System.out.println("Prices with VAT:");
        for (Double d : list) {
            System.out.printf("%.2f%n",   vatAdded.apply(d));
        }

    }
}
