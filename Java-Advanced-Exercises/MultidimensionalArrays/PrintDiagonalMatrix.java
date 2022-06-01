import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] result = new int[2][n];
        findFirstRow(matrix, result);
        findSecondRow(matrix, result);
        printResult(result);

    }


    public static void findFirstRow(int[][] matrix, int[][] result) {
        int counterRow = 0;
        int counterCol = 0;
        for (int row = 0; row < 1; row++) {

            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = matrix[counterRow][counterCol];
                counterRow++;
                counterCol++;
            }
        }
    }

    public static void findSecondRow(int[][] matrix, int[][] result) {
        int counterCol = 0;
        int counterRow = matrix.length - 1;
        for (int row = 1; row > 0; row--) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = matrix[counterRow][counterCol];
                counterRow--;
                counterCol++;
            }
        }
    }

    public static void printResult(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
