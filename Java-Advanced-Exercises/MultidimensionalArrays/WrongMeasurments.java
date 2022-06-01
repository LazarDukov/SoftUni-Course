import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrixIn = new int[n][];
        matrixDataPush(matrixIn, scanner, n);
       int wrongNumber =  wrongNumber(matrixIn, scanner);
        int[] indexes = new int[2];
        int rowIndex = indexes[0];
        int colIndex = indexes[1];
        int sumOfWrongNumber = 0;
        int[][] matrixNew = new int[n][matrixIn[0].length];
        for (int r = 0; r < matrixIn.length; r++) {
            for (int c = 0; c < matrixIn[r].length; c++) {
                if (wrongNumber == matrixIn[r][c]) {
                    rowIndex = r;
                    colIndex = c;
                    if (rowIndex > 0 && matrixIn[r-1][c] != wrongNumber) {
                        sumOfWrongNumber += matrixIn[r-1][c];
                    }
                    if (colIndex > 0 && matrixIn[r][c-1] != wrongNumber) {
                        sumOfWrongNumber += matrixIn[r][c-1];
                    }
                    if (rowIndex < matrixIn.length-1 && matrixIn[r+1][c] != wrongNumber) {
                        sumOfWrongNumber += matrixIn[r+1][c];
                    }
                    if (colIndex < matrixIn[r].length-1 && matrixIn[r][c+1] != wrongNumber) {
                        sumOfWrongNumber+= matrixIn[r][c+1];
                    }
                    matrixNew[r][c] = sumOfWrongNumber;
                    sumOfWrongNumber = 0;
                } else {
                    matrixNew[r][c] = matrixIn[r][c];
                }
            }
        }
        printLastResult(matrixNew);
    }
public static void printLastResult(int[][] matrixNew) {
    for (int r = 0; r < matrixNew.length; r++) {
        for (int c = 0; c < matrixNew[r].length; c++) {
            System.out.print(matrixNew[r][c] + " ");
        }
        System.out.println();
    }
}


    public static int wrongNumber(int[][] matrixIn, Scanner scanner) {
        int[] indexesOfWrongNumber = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int indexRow = indexesOfWrongNumber[0];
        int indexCol = indexesOfWrongNumber[1];
        int number = matrixIn[indexRow][indexCol];

        return number;
    }
    public static void matrixDataPush(int[][] matrixIn, Scanner scanner, int n) {
        for (int r = 0; r < matrixIn.length; r++) {
            matrixIn[r] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

    }
}
