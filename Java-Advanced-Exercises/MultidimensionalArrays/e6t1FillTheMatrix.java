import java.util.Scanner;

public class e6t1FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputs = scanner.nextLine().split("[,]\\s+");
        int sizeMatrix = Integer.parseInt(inputs[0]);
        String pattern = inputs[1];
        int[][] matrix;
        if (pattern.equals("A")) {
            matrix = makeMatrixA(sizeMatrix);
        } else {
            matrix = makeMatrixB(sizeMatrix);
        }
        print(matrix);

    }

    public static void print(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] makeMatrixA(int sizeMatrix) {
        int[][] newMatrixA = new int[sizeMatrix][sizeMatrix];
        int row = newMatrixA[0][0];
        int counter = 1;
        for (int c = 0; c < newMatrixA[row].length; c++) {
            for (int r = 0; r < newMatrixA.length; r++) {

                newMatrixA[r][c] += counter;
                counter++;
            }
        }
        return newMatrixA;
    }

    public static int[][] makeMatrixB(int sizeMatrix) {
        int[][] newMatrixB = new int[sizeMatrix][sizeMatrix];
        int row = newMatrixB[0][0];
        int counter = 1;
        for (int c = 0; c < newMatrixB[row].length; c++) {
            if (c % 2 == 0) {
                for (int r = 0; r < newMatrixB.length; r++) {
                    newMatrixB[r][c] += counter;
                    counter++;
                }
            } else {
                for (int r = newMatrixB.length - 1; r >= 0; r--) {
                    newMatrixB[r][c] += counter;
                    counter++;
                }
            }
        }


        return newMatrixB;
    }
}
