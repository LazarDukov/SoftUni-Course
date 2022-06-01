import java.util.Scanner;

public class InteresctionOfMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrixA = createAMatrix(scanner);
        String[][] matrixB = createBMatrix(scanner, matrixA);
        String[][] matrixC = createAmatrixC(matrixA, matrixB);
printCmatrix(matrixC);
    }
    public static String[][] createAMatrix(Scanner scanner) {
        String rows = scanner.nextLine();
        String cols = scanner.nextLine();
        String[][] matrix = new String[Integer.parseInt(rows)][Integer.parseInt(cols)];
        for (int row = 0; row < Integer.parseInt(rows); row++) {
            for (int col= 0; col < Integer.parseInt(cols); col++) {
                matrix[row][col] = scanner.next();
            }
        }
        return matrix;
    }
    public static String[][] createBMatrix(Scanner scanner, String[][] matrixA) {
        int counterOfCols = 0;
        for (int checkRows = 0; checkRows < 1; checkRows++) {
            for (int checkCols = 0; checkCols < matrixA[checkRows].length; checkCols++) {
                counterOfCols += 1;
            }
        }
        String[][] matrix = new String[matrixA.length][counterOfCols];
        for (int row = 0; row < matrixA.length; row++) {
            for (int col= 0; col < counterOfCols; col++) {
                matrix[row][col] = scanner.next();
            }
        }
        return matrix;
    }
    public static String[][] createAmatrixC(String[][] matrixA, String[][] matrixB) {
        int counterOfCols = 0;
        for (int checkRows = 0; checkRows < 1; checkRows++) {
            for (int checkCols = 0; checkCols < matrixA[checkRows].length; checkCols++) {
                counterOfCols += 1;
            }
        }
        String[][] matrixC = new String[matrixA.length][counterOfCols];
        for (int row = 0; row < matrixA.length; row++) {
            for (int col = 0; col < counterOfCols; col++) {
                if (matrixA[row][col].equals(matrixB[row][col])) {
                    matrixC[row][col] = matrixA[row][col];
                } else {
                    matrixC[row][col] = "*";
                }
            }
        }

        return matrixC;
    }
    public static void printCmatrix(String[][] matrixC) {
        for (int i = 0; i < matrixC.length; i++) {
            for (int j = 0; j < matrixC[i].length; j++) {
                System.out.print(matrixC[i][j] + " ");
            }
            System.out.println();
        }
    }
}
