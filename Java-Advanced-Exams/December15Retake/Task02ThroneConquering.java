import java.util.Scanner;

public class dec15ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        int matrixRows = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[matrixRows][matrixRows];
        int helensRow = -1;
        int helensCol = -1;
        int parisRow = -1;
        int parisCol = -1;
        for (int i = 0; i < matrixRows; i++) {
            String rowsLook = scanner.nextLine();
            for (int j = 0; j < rowsLook.length(); j++) {
                field[i][j] = rowsLook.charAt(j);
                if (rowsLook.charAt(j) == 'H') {
                    helensRow = i;
                    helensCol = j;

                }
                if (rowsLook.charAt(j) == 'P') {
                    parisRow = i;
                    parisCol = j;
                }
            }
        }

        boolean isHelenReached = false;
        while (isHelenReached || energy > 0) {
            field[parisRow][parisCol] = '-';
            energy--;
            String[] data = scanner.nextLine().split("\\s+");
            String command = data[0];
            int enemyRow = Integer.parseInt(data[1]);
            int enemyCol = Integer.parseInt(data[2]);
            field[enemyRow][enemyCol] = 'S';
            if (command.equals("up") && parisRow - 1 >= 0) {
                parisRow--;

            } else if (command.equals("down") && parisRow + 1 <= field.length - 1) {
                parisRow++;

            } else if (command.equals("left") && parisCol - 1 >= 0) {
                parisCol--;

            } else if (command.equals("right") && parisCol + 1 <= field[0].length - 1) {
                parisCol++;

            }
            if (field[parisRow][parisCol] == 'H') {
                System.out.print("Paris has successfully abducted Helen! ");
                isHelenReached = true;
                field[parisRow][parisCol] = '-';
                break;
            }

            if (energy <= 0) {
                field[parisRow][parisCol] = 'X';
                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                break;
            }
            if (field[parisRow][parisCol] == 'S') {
                energy -= 2;
                if (energy <= 0) {
                    field[parisRow][parisCol] = '-';
                    break;
                }
            }
            field[parisRow][parisCol] = 'P';
        }
        if (energy > 0) {
            System.out.println("Energy left: " + energy);
        }
        if (energy <= 0 && isHelenReached) {
            System.out.println("Energy left: " + energy);

        }

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

}
