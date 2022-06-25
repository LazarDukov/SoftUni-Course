import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class june25StickyFingers {
    public static int dillingerRow = -1;
    public static int dillingerCol = -1;
    public static boolean isMoved = false;


    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        int fieldSize = Integer.parseInt(cs.nextLine());

        String[] commandsInput = cs.nextLine().split("[,]");
        ArrayDeque<String> commands = new ArrayDeque<>(Arrays.asList(commandsInput));

        char[][] field = new char[fieldSize][fieldSize];
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                field[r][c] = cs.next().charAt(0);
                if (field[r][c] == 'D') {
                    dillingerRow = r;
                    dillingerCol = c;
                }
            }
        }

        int pocket = 0;
        boolean isCaught = false;
        while (!commands.isEmpty()) {
            String command = commands.poll();
            int lastStepRow = dillingerRow;
            int lastStepCol = dillingerCol;
            move(command, field);

            if (isMoved) {
                field[lastStepRow][lastStepCol] = '+';
            }
            if (field[dillingerRow][dillingerCol] == '$') {
                field[dillingerRow][dillingerCol] = '+';
                int stolenMoney = dillingerRow * dillingerCol;
                pocket += stolenMoney;
                System.out.println("You successfully stole " + stolenMoney + "$.");
            }
            if (field[dillingerRow][dillingerCol] == 'P') {
                field[dillingerRow][dillingerCol] = '#';
                isCaught = true;
                System.out.println("You got caught with " + pocket + "$, and you are going to jail.");
                break;
            }
            field[dillingerRow][dillingerCol] = 'D';
            isMoved = false;
        }
        if (commands.isEmpty() && !isCaught) {
            System.out.println("Your last theft has finished successfully with " + pocket + "$ in your pocket.");
        }
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c] + " ");
            }
            System.out.println();
        }


    }

    public static void move(String command, char[][] field) {
        switch (command) {
            case "up":
                if (dillingerRow == 0) {
                    System.out.println("You cannot leave the town, there is police outside!");
                } else {
                    dillingerRow--;
                    isMoved = true;
                }
                break;
            case "down":
                if (dillingerRow == field.length - 1) {
                    System.out.println("You cannot leave the town, there is police outside!");
                } else {
                    dillingerRow++;
                    isMoved = true;
                }
                break;
            case "left":
                if (dillingerCol == 0) {
                    System.out.println("You cannot leave the town, there is police outside!");
                } else {
                    dillingerCol--;
                    isMoved = true;
                }
                break;
            case "right":
                if (dillingerCol == field[0].length - 1) {
                    System.out.println("You cannot leave the town, there is police outside!");
                } else {
                    dillingerCol++;
                    isMoved = true;
                }
                break;

        }
    }

}
