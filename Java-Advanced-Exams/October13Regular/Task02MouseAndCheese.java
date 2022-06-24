import java.util.Scanner;

public class oct23MouseAndCheese {
    public static int rowOfMouse = -1;
    public static int colOfMouse = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        int cheese = 0;
        for (int r = 0; r < size; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 'M') {
                    rowOfMouse = r;
                    colOfMouse = c;
                }
            }
        }
        boolean isOut = false;
        String command = scanner.nextLine();
        while (!(command.equals("end") || isOut)) {
            matrix[rowOfMouse][colOfMouse] = '-';
            move(matrix, command);
            if (isOut(matrix, rowOfMouse, colOfMouse)) {
                isOut = true;
                break;

            }

            if (matrix[rowOfMouse][colOfMouse] == 'B') {
                matrix[rowOfMouse][colOfMouse] = '-';
                move(matrix, command);
            }
            if (matrix[rowOfMouse][colOfMouse] == 'c') {
                matrix[rowOfMouse][colOfMouse] = '-';
                cheese++;
            }
            if (!isOut) {
                matrix[rowOfMouse][colOfMouse] = 'M';

            }
            command = scanner.nextLine();
        }
        if (isOut) {
            System.out.println("Where is the mouse?");
        }
        if (cheese < 5) {
            int diff = 5 - cheese;
            System.out.println("The mouse couldn't eat the cheeses, she needed " + diff + " cheeses more.");
        } else {
            System.out.println("Great job, the mouse is fed " + cheese + " cheeses!");
        }
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }

    }

    public static boolean isOut(char[][] matrix, int rowOfMouse, int colOfMouse) {
        if (rowOfMouse < 0 || rowOfMouse >= matrix.length || colOfMouse < 0 || colOfMouse >= matrix[0].length) {
            return true;
        }
        return false;
    }

    public static void move(char[][] matrix, String command) {
        switch (command) {
            case "up":
                rowOfMouse--;
                break;
            case "down":
                rowOfMouse++;
                break;
            case "left":
                colOfMouse--;
                break;
            case "right":
                colOfMouse++;
                break;
        }
    }
}
