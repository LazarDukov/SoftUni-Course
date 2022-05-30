import java.util.Arrays;
import java.util.Scanner;

public class e6t4MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] bigMatrix = inputData(scanner);
        int[][] theBiggestMatrix3x3 = new int[3][3];
        int sumOfTheBiggstMatrix3x3 = 0;
        int iterationToDo = (bigMatrix.length - 2) * (bigMatrix[0].length - 2);
        int bigMatrixRowCount = 0;
        int bigMatrixColCount = 0;
        for (int i = 0; i < iterationToDo; i++) {

            int[][] smallMatrix3x3 = dataForSmallMatrix3x3(bigMatrix, bigMatrixRowCount, bigMatrixColCount);
            bigMatrixRowCount++;
            if (bigMatrixRowCount == bigMatrix.length - 2) {
                bigMatrixRowCount = 0;
                bigMatrixColCount++;
            }

            int sumOfSmallMatrix3x3 = sumOfMatrix(smallMatrix3x3);
            if (sumOfTheBiggstMatrix3x3 < sumOfSmallMatrix3x3) {
                sumOfTheBiggstMatrix3x3 = isThisMatrixBigger(sumOfTheBiggstMatrix3x3, sumOfSmallMatrix3x3);
                theBiggestMatrix3x3 = smallMatrix3x3;
            }

        }

        printSum(sumOfTheBiggstMatrix3x3);
        printMatrix(sumOfTheBiggstMatrix3x3, theBiggestMatrix3x3);
    }

    public static void printSum(int finallySum) {
        System.out.println("Sum = " + finallySum);
    }

    public static void printMatrix(int finallySum, int[][] lastMatrix) {
        for (int r = 0; r < lastMatrix.length; r++) {
            for (int c = 0; c < lastMatrix[r].length; c++) {
                System.out.print(lastMatrix[r][c] + " ");
            }
            System.out.println();
        }

    }

    public static int isThisMatrixBigger(int finallySum, int sumSmallMatrix) {
        if (finallySum < sumSmallMatrix) {
            return sumSmallMatrix;
        }
        return finallySum;
    }

    public static int sumOfMatrix(int[][] smallMatrix) {
        int sum = 0;
        for (int r = 0; r < smallMatrix.length; r++) {
            for (int c = 0; c < smallMatrix[r].length; c++) {
                sum += smallMatrix[r][c];
            }
        }
        return sum;
    }

    public static int[][] dataForSmallMatrix3x3(int[][] bigMatrix, int counterOfRows, int counterOfCols) {
        int[][] smallMatrix = new int[3][3];
        int newMatrixRows = 0;
        int newMatrixCols = 0;
        for (int r = counterOfRows; r < 3 + counterOfRows; r++) {

            for (int c = counterOfCols; c < 3 + counterOfCols; c++) {
                smallMatrix[newMatrixRows][newMatrixCols] = bigMatrix[r][c];
                newMatrixCols++;
            }
            newMatrixCols = 0;
            newMatrixRows++;
        }

        return smallMatrix;
    }

    public static int[][] inputData(Scanner scanner) {
        int[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] bigMatrix = dataForThisMatrix(scanner, input);
        return bigMatrix;
    }

    public static int[][] dataForThisMatrix(Scanner scanner, int[] input) {
        int[][] matrix = new int[input[0]][input[1]];
        for (int r = 0; r < input[0]; r++) {
            matrix[r] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }

}
