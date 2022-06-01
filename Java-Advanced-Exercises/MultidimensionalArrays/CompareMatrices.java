import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix1 = matrix(scanner);
        int[][] matrix2 = matrix(scanner);
        boolean areTheyEqual = isEqual(matrix1, matrix2);
        if (areTheyEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static int[][] matrix(Scanner scanner) {
        int rows = Integer.parseInt(scanner.next());
        int columns = Integer.parseInt(scanner.next());
        int[][] matrix = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                matrix[row][col] = Integer.parseInt(scanner.next());
            }
        }

        return matrix;
    }

    public static boolean isEqual(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i].length != matrix2[i].length) {
                return false;
            }
            for (int j = 0; j < matrix1[i].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
