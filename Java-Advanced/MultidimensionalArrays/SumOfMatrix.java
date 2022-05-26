import java.util.Arrays;
import java.util.Scanner;

public class SumOfMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizeOfMatrix = Arrays.stream(scanner.nextLine().split("[,]\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = sizeOfMatrix[0];
        int cols = sizeOfMatrix[1];
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] elementsOfEachRow = Arrays.stream(scanner.nextLine().split("[,]\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = elementsOfEachRow;
        }
        int sumOfAllElements = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sumOfAllElements+=matrix[row][col];
            }
        }
        System.out.println(rows + "\n" + cols + "\n" + sumOfAllElements);
    }
}
