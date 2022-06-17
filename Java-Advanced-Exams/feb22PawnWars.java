import java.util.Scanner;

public class feb22PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] chessBoard = new String[8][];
        int wRow = -1;
        int wCol = -1;
        int bRow = -1;
        int bCol = -1;
        String wSymbol = "";
        String bSymbol = "";
        String wIndex = "";
        String bIndex = "";
        for (int i = 0; i < 8; i++) {
            String[] newLineInput = scanner.nextLine().split("");
            chessBoard[i] = newLineInput;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard[i][j].equals("w")) {
                    wRow = i;
                    wCol = j;
                } else if (chessBoard[i][j].equals("b")) {
                    bRow = i;
                    bCol = j;
                }
            }
        }
        int turn = 0; // 0 for white 1 for black

        while (wRow != 0 && bRow != 7) {

            wIndex = index(wRow);
            bIndex = index(bRow);
            wSymbol = symbol(wCol);
            bSymbol = symbol(bCol);

            if ((wRow - 1 == bRow && wCol - 1 == bCol) || ((wRow - 1 == bRow && wCol + 1 == bCol))) {

                if (turn == 0) {
                    System.out.printf("Game over! White capture on %s%s.", bSymbol, bIndex);
                    break;
                } else if (turn == 1) {
                    System.out.printf("Game over! Black capture on %s%s.", wSymbol, wIndex);
                    break;
                }

            } //else if ((bRow + 1 == wRow && bCol - 1 == wCol) || (bRow + 1 == wRow && bCol + 1 == wCol) && turn == 1) {
            // System.out.printf("Game over! Black capture on %s%s.", wSymbol, wIndex);
            //   break;
            //  }


            if (turn == 0) {
                chessBoard[wRow][wCol] = "-";
                wRow--;
                chessBoard[wRow][wCol] = "w";
                turn = 1;
            } else {
                chessBoard[bRow][bCol] = "-";
                bRow++;
                chessBoard[bRow][bCol] = "b";
                turn = 0;
            }

        }
        wIndex = index(wRow);
        bIndex = index(bRow);
        if (wRow == 0) {
            wRow = 8;
            System.out.printf("Game over! White pawn is promoted to a queen at %s%d.", wSymbol, wRow);
        } else if (bRow == 7) {
            bRow = 1;
            System.out.printf("Game over! Black pawn is promoted to a queen at %s%d.", bSymbol, bRow);
        }
        System.out.println();
    }

    public static String index(int row) {
        String index = "";
        if (row == 0) {
            index = "8";
        } else if (row == 1) {
            index = "7";
        } else if (row == 2) {
            index = "6";
        } else if (row == 3) {
            index = "5";
        } else if (row == 4) {
            index = "4";
        } else if (row == 5) {
            index = "3";
        } else if (row == 6) {
            index = "2";
        } else if (row == 7) {
            index = "1";
        }
        return index;
    }
    public static String symbol(int col) {
        String symbol = "";
        if (col == 0) {
            symbol = "a";
        } else if (col == 1) {
            symbol = "b";
        } else if (col == 2) {
            symbol = "c";
        } else if (col == 3) {
            symbol = "d";
        } else if (col == 4) {
            symbol = "e";
        } else if (col == 5) {
            symbol = "f";
        } else if (col == 6) {
            symbol = "g";
        } else if (col == 7) {
            symbol = "h";
        }
        return symbol;
    }
}
