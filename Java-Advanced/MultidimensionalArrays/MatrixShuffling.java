import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] matrix = inputMatrix(scanner);
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] toDo = command.split(" ");
            if (toDo[0].equals("swap") && toDo.length == 5) {
                int row1 = Integer.parseInt(toDo[1]);
                int col1 = Integer.parseInt(toDo[2]);
                int row2 = Integer.parseInt(toDo[3]);
                int col2 = Integer.parseInt(toDo[4]);
                if (toDo[0].equals("swap")
                        && row1 >= 0
                        && row1 < matrix.length
                        && row2 >= 0
                        && row2 < matrix.length
                        && col1 >= 0
                        && col1 < matrix[0].length
                        && col2 >= 0
                        && col2 < matrix[0].length) {
                    String numberPrevious = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = numberPrevious;

                    print(matrix);
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }

    public static void print(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }

    }

    public static String[][] inputMatrix(Scanner scanner) {
        String[] sizes = scanner.nextLine().split(" ");
        String[][] matrix = new String[Integer.parseInt(sizes[0])][Integer.parseInt(sizes[1])];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().split(" ");
        }
        return matrix;
    }

}
