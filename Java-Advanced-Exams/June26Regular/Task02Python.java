import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class june26PythonProblems {
    public static int snakeRow = -1;
    public static int snakeCol = -1;

    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        int size = Integer.parseInt(cs.nextLine());

        String[] commandsInput = cs.nextLine().split(", ");
        ArrayDeque<String> commands = new ArrayDeque<>(Arrays.asList(commandsInput));

        char[][] field = new char[size][size];
        int snakeLength = 1;
        int foodPlacedOnField = 0;
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                field[r][c] = cs.next().charAt(0);
                if (field[r][c] == 's') {
                    snakeRow = r;
                    snakeCol = c;
                } else if (field[r][c] == 'f') {
                    foodPlacedOnField++;
                }
            }
        }
        boolean isWin = false;
        boolean isHitEnemy = false;
        while (!commands.isEmpty()) {
            String command = commands.poll();
            move(command, field);
            check(field);
            if (field[snakeRow][snakeCol] == 'f') {
                snakeLength++;
                foodPlacedOnField--;
                if (foodPlacedOnField == 0) {
                    System.out.println("You win! Final python length is " + snakeLength);
                    isWin = true;
                    break;
                }
            }
            if (field[snakeRow][snakeCol] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                isHitEnemy = true;
            }
        }
        if (!(isWin || isHitEnemy)) {
            System.out.println("You lose! There is still " + foodPlacedOnField + " food to be eaten.");
        }
    }

    public static void move(String command, char[][] field) {
        switch (command) {
            case "up":
                snakeRow--;
                break;
            case "down":
                snakeRow++;
                break;
            case "left":
                snakeCol--;
                break;
            case "right":
                snakeCol++;
                break;
        }

    }

    public static void check(char[][] field) {
        if (snakeRow < 0) {
            snakeRow = field.length - 1;
        } else if (snakeRow == field.length) {
            snakeRow = 0;
        } else if (snakeCol < 0) {
            snakeCol = field[snakeRow].length - 1;
        } else if (snakeCol == field[snakeRow].length) {
            snakeCol = 0;
        }
    }
}
