import java.util.*;

public class apr13Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeMatrix = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[sizeMatrix][sizeMatrix];
        int officerRow = -1;
        int officerCol = -1;
        int swordRow = -1;
        int swordCol = -1;
        Map<String, List<Integer>> mirrors = new HashMap<>();
        mirrors.put("mirrorOne", new ArrayList<>());
        mirrors.put("mirrorTwo", new ArrayList<>());
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = scanner.nextLine().toCharArray();
            for (int c = 0; c < matrix[r].length; c++) {
                matrix[r][c] = matrix[r][c];
                if (matrix[r][c] == 'A') {
                    officerRow = r;
                    officerCol = c;
                } else if (matrix[r][c] >= 49 && matrix[r][c] <= 57) {
                    swordRow = r;
                    swordCol = c;
                } else if (matrix[r][c] == 'M') {
                    if (mirrors.get("mirrorOne").isEmpty()) {
                        mirrors.get("mirrorOne").add(r);
                        mirrors.get("mirrorOne").add(c);
                    } else {
                        mirrors.get("mirrorTwo").add(r);
                        mirrors.get("mirrorTwo").add(c);
                    }
                }

            }
        }
        int blades = 0;
        boolean isOut = false;
        while (blades < 65 && !isOut) {
            String command = scanner.nextLine();
            matrix[officerRow][officerCol] = '-';
            switch (command) {
                case "up":
                    officerRow--;
                    break;
                case "down":
                    officerRow++;
                    break;
                case "right":
                    officerCol++;
                    break;
                case "left":
                    officerCol--;
                    break;
            }
            if (isOutOfField(officerRow, officerCol, matrix)) {
                isOut = true;
                break;
            }

            if (isDigit(officerRow, officerCol, matrix) != -1) {
                char number = matrix[officerRow][officerCol];
                blades += Character.getNumericValue(number);
            } else if (matrix[officerRow][officerCol] == 'M') {
                if (mirrors.get("mirrorOne").get(0) == officerRow && mirrors.get("mirrorOne").get(1) == officerCol) {
                    matrix[officerRow][officerCol] = '-';
                    officerRow = mirrors.get("mirrorTwo").get(0);
                    officerCol = mirrors.get("mirrorTwo").get(1);
                    mirrors.remove("mirrorOne");
                    mirrors.remove("mirrorTwo");
                    matrix[officerRow][officerCol] = 'A';
                } else if (mirrors.get("mirrorTwo").get(0) == officerRow && mirrors.get("mirrorTwo").get(1) == officerCol) {
                    matrix[officerRow][officerCol] = '-';
                    officerRow = mirrors.get("mirrorOne").get(0);
                    officerCol = mirrors.get("mirrorOne").get(1);
                    mirrors.remove("mirrorOne");
                    mirrors.remove("mirrorTwo");
                    matrix[officerRow][officerCol] = 'A';
                }
            }
            matrix[officerRow][officerCol] = 'A';
        }
        if (isOut) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.println("The king paid " + blades + " gold coins.");
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    public static boolean isOutOfField(int officerRow, int officerCol, char[][] matrix) {
        boolean isOut = false;
        if (officerRow >= matrix.length || officerRow < 0) {
            return true;
        } else if (officerCol >= matrix[0].length || officerCol < 0) {
            return true;
        }
        return false;

    }

    public static int isDigit(int officerRow, int officerCol, char[][] matrix) {
        int digit = -1;
        if (matrix[officerRow][officerCol] >= 48 && matrix[officerRow][officerCol] <= 57) {
            digit = matrix[officerRow][officerCol];
        }
        return digit;
    }
}
