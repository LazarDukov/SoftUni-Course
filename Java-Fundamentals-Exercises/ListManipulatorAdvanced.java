import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulatorAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] inputArray = input.split("\\s+");

            if (inputArray[0].equals("Contains")) {
                int number = Integer.parseInt(inputArray[1]);
                int checkValueOfList = 0;
                for (int i = 0; i < numbers.size(); i++) {
                    checkValueOfList = numbers.get(i);
                    if (checkValueOfList == number) {
                        System.out.println("Yes");
                        break;
                    }
                }
                if (checkValueOfList != number) {
                    System.out.println("No such number");
                }
            }
            if (inputArray[0].equals("Print")) {
                if (inputArray[1].equals("even")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) % 2 == 0) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }

                } else if (inputArray[1].equals("odd")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) % 2 != 0) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                }
                System.out.println();
            }
            if (inputArray[0].equals("Get") && inputArray[1].equals("sum")) {
                int getSum = 0;
                for (int i = 0; i < numbers.size(); i++) {
                    getSum += numbers.get(i);
                }
                System.out.println(getSum);
            }
            if (inputArray[0].equals("Filter")) {
                if (inputArray[1].equals("<")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (Integer.parseInt(inputArray[2]) > numbers.get(i)) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                } else if (inputArray[1].equals(">")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (Integer.parseInt(inputArray[2]) < numbers.get(i)) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                } else if (inputArray[1].equals("<=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (Integer.parseInt(inputArray[2]) >= numbers.get(i)) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                } else if (inputArray[1].equals(">=")) {
                    for (int i = 0; i < numbers.size(); i++) {
                        if (Integer.parseInt(inputArray[2]) <= numbers.get(i)) {
                            System.out.print(numbers.get(i) + " ");
                        }
                    }
                    System.out.println();
                }

            }
            input = scanner.nextLine();
        }

    }
}
