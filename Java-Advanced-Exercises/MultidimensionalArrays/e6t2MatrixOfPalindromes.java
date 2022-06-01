import java.util.Scanner;

public class e6t2MatrixOfPalindromes {
    public static String[][] inputData(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] inputData = new String[rows][cols];
        return inputData;
    }

    public static String[][] addRowsAndColumnsOfMatrix(String[][] inputData) {
        String[][] myMatrix = inputData;
        for (int r = 0; r < myMatrix.length; r++) {
            char letter1 = 97;
            letter1 += r;
            char letter2 = 97;
            letter2 += r;
            char letter3 = 97;
            letter3 += r;
            for (int c = 0; c < myMatrix[r].length; c++) {

                char[] letters = {letter1, letter2, letter3};
                myMatrix[r][c] = String.copyValueOf(letters);
                letter2++;
            }
        }
        return myMatrix;
    }

    public static void printMatrix(String[][] myMatrix) {
        for (int r = 0; r < myMatrix.length; r++) {
            for (int c = 0; c < myMatrix[r].length; c++) {
                System.out.print(myMatrix[r][c] + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] myMatrix = inputData(scanner);
        addRowsAndColumnsOfMatrix(myMatrix);
        printMatrix(myMatrix);

    }
}
