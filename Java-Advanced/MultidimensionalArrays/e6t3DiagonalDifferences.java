import java.util.Arrays;
import java.util.Scanner;

public class e6t3DiagonalDifferences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = inputData(scanner);
        int upToDownNumber = giveMeUpToDownNumber(matrix);
        int downToUpNumber = giveMeDownToUpNumber(matrix);
        int difference = differenceOfTheseNumbers(upToDownNumber, downToUpNumber);
        printDifference(difference);
        System.out.println();
    }

    public static int[][] inputData(Scanner scanner) {

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][];
        for (int r = 0; r < matrix.length; r++) {
            int[] cols = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[r] = cols;
        }

        return matrix;
    }

    public static int giveMeUpToDownNumber(int[][] matrix) {
        int number = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < 1; c++) {
                number += matrix[r][r];
            }
        }
        return number;
    }

    public static int giveMeDownToUpNumber(int[][] matrix) {
        int number = 0;
        int counterOfColumns = 0;
        for (int r = matrix.length-1; r >= 0 ; r--) {
            for (int c = 0; c < 1; c++) {
                number+= matrix[r][counterOfColumns];
                counterOfColumns++;
            }
        }

        return number;
    }
    public static int differenceOfTheseNumbers(int number1, int number2) {
        int sum = number1-number2;
        int giveMeAbs = Math.abs(sum);
        return giveMeAbs;
    }
    public static void printDifference(int difference) {
        System.out.println(difference);
    }
}
