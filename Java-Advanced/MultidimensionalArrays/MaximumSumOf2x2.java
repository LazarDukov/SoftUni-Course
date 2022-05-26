import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrixInput = matrix(scanner);
        int[][] smallMatrix = new int[2][2];
        int sumOfAllElements = 0;
        int first = 0;
        int second = 0;
        int third = 0;
        int fourth = 0;
        for (int row = 0; row < matrixInput.length - 1; row++) {

            for (int col = 0; col < matrixInput[row].length - 1; col++) {

                int sumOfTheseElements = 0;


                for (int elOfRow = row; elOfRow < 2 + row; elOfRow++) {

                    for (int elOfCol = col; elOfCol < 2 + col; elOfCol++) {

                        sumOfTheseElements += matrixInput[elOfRow][elOfCol];
                        first = matrixInput[0 + row][0 + col];
                        second = matrixInput[0 + row][1 + col];
                        third = matrixInput[1 + row][0 + col];
                        fourth = matrixInput[1 + row][1 + col];
                    }
                }

                if (sumOfAllElements < sumOfTheseElements) {
                    sumOfAllElements = sumOfTheseElements;
                    smallMatrix[0][0] = first;
                    smallMatrix[0][1] = second;
                    smallMatrix[1][0] = third;
                    smallMatrix[1][1] = fourth;
                }
            }
        }
        printLastResult(smallMatrix);
        System.out.println(sumOfAllElements);
    }


    public static int[][] matrix(Scanner scanner) {
        int[] sizes = Arrays.stream(scanner.nextLine().split("[,]\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrixInput = new int[sizes[0]][sizes[1]];
        for (int row = 0; row < matrixInput.length; row++) {
            matrixInput[row] = Arrays.stream(scanner.nextLine().split("[,]\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        return matrixInput;
    }


    public static void printLastResult(int[][] smallMatrix) {
        for (int i = 0; i < smallMatrix.length; i++) {
            for (int j = 0; j < smallMatrix[i].length; j++) {
                System.out.print(smallMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
