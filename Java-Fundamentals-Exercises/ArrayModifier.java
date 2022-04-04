import java.util.Scanner;

public class ArrayModifier {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputSplit = input.split(" ");
        int[] inputNumbers = new int[inputSplit.length];
        for (int i = 0; i < inputNumbers.length; i++) {
            inputNumbers[i] = Integer.parseInt(inputSplit[i]);
        }
        String inputs = scanner.nextLine();

        while (!inputs.equals("end")) {
            String[] inputFunc = inputs.split(" ");
            int[] inputFunctions = new int[2];
            if (inputFunc[0].equals("decrease")) {
                for (int j = 0; j < inputNumbers.length; j++) {
                    inputNumbers[j] = inputNumbers[j] - 1;
                }
            }
            if (!inputFunc[0].equals("decrease")) {
                for (int i = 0; i < 1; i++) {
                    inputFunctions[0] = Integer.parseInt(inputFunc[1]);
                    inputFunctions[1] = Integer.parseInt(inputFunc[2]);
                    int numberOne = inputNumbers[inputFunctions[0]];
                    int numberTwo = inputNumbers[inputFunctions[1]];
                    if (inputFunc[0].equals("swap")) {
                        inputNumbers[inputFunctions[0]] = numberTwo;
                        inputNumbers[inputFunctions[1]] = numberOne;
                    } else if (inputFunc[0].equals("multiply")) {
                        inputNumbers[inputFunctions[0]] = numberTwo * numberOne;
                    }
                }
            }
            inputs = scanner.nextLine();

        }
        for (int i = 0; i < inputNumbers.length - 1; i++) {
            System.out.print(inputNumbers[i] + ", ");
        }
        System.out.print(inputNumbers[inputNumbers.length - 1]);
    }
    
}
