import java.util.Scanner;

public class aug18FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int commandsNumber = Integer.parseInt(scanner.nextLine());
        char[][] field = new char[rows][rows];

        boolean isMatches = false;
        for (int r = 0; r < field.length; r++) {
            field[r] = scanner.nextLine().toCharArray();
        }
        int[] playerIndexes = index(field);
        int row = playerIndexes[0];
        int col = playerIndexes[1];
        while (commandsNumber-- > 0 && !isMatches) {
            String command = scanner.nextLine();
            int oldRow = row;
            int oldCol = col;
            field[row][col] = '.';
            turn(playerIndexes, command, field);
            row = playerIndexes[0];
            col = playerIndexes[1];
            if (field[row][col] == 'B') {
                oldRow = row;
                oldCol = col;
                turn(playerIndexes, command, field);
                row = playerIndexes[0];
                col = playerIndexes[1];
            }
            if (field[row][col] == 'T') {

                row = oldRow;
                col = oldCol;
                playerIndexes[0] = row;
                playerIndexes[1] = col;
            }
            if (field[row][col] == 'F') {
                isMatches = true;
            }
            field[row][col] = 'P';
        }
        if (isMatches) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[0].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }


    }

    public static int[] index(char[][] field) {
        int[] indexes = new int[2];
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c] == 'P') {
                    indexes[0] = r;
                    indexes[1] = c;
                }
            }
        }
        return indexes;
    }

    public static void turn(int[] playerIndexes, String command, char[][] field) {
        switch (command) {
            case "up":
                if (playerIndexes[0] > 0) {
                    playerIndexes[0]--;
                } else {
                    playerIndexes[0] = field.length - 1;
                }
                break;
            case "down":
                if (playerIndexes[0] < field.length - 1) {
                    playerIndexes[0]++;
                } else {
                    playerIndexes[0] = 0;
                }
                break;
            case "left":
                if (playerIndexes[1] > 0) {
                    playerIndexes[1]--;
                } else {
                    playerIndexes[1] = field[0].length - 1;
                }
                break;
            case "right":
                if (playerIndexes[1] < field[0].length - 1) {
                    playerIndexes[1]++;
                } else {
                    playerIndexes[1] = 0;
                }
                break;
        }

    }
}