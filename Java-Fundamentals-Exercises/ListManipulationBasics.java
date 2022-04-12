import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        while (!input.equals("end")) {
           String inputer = input.split(" ")[0];
                if (inputer.equals("Add")) {
                    int number = Integer.parseInt(input.split(" ")[1]);
                    numbers.add(number);
                } else if (inputer.equals("Remove")) {
                    int number = Integer.parseInt(input.split(" ")[1]);
                    numbers.remove(Integer.valueOf(number));
                }else if (inputer.equals("RemoveAt")) {
                    int number = Integer.parseInt(input.split(" ")[1]);
                    numbers.remove(number);
                }else if (inputer.equals("Insert")) {
                    int number = Integer.parseInt(input.split(" ")[1]);
                    int number1 = Integer.parseInt(input.split(" ")[2]);
                    numbers.add(number1, number);
                }

            input = scanner.nextLine();
        }
        for (int n : numbers) {
            System.out.print(n + " ");
        }
    }
}
