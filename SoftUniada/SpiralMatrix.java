import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][columns];
        List<Integer> list = new ArrayList<>();
        int rowCounter = 0;
        int columnsCounter = 0;
        int stopTheWhile = rows*columns;
        boolean isListSizeEqualToStop = false;
        // create the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        while (!isListSizeEqualToStop) {
            // Iterate the first row ( from first symbol to the last symbol )
            for (int i = 0; i < columns - columnsCounter; i++) {
                list.add(list.size(), matrix[rowCounter][i+columnsCounter]);
                if (list.size() == stopTheWhile) {
                    isListSizeEqualToStop=true;
                    break;
                }
            }
            if (isListSizeEqualToStop) {
                break;
            }
            // Iterate last indexes of every row without first and last
            for (int i = rowCounter; i < rows - 2; i++) {
                list.add(list.size(), matrix[i+1][columns - 1]);
                if (list.size() == stopTheWhile) {
                    isListSizeEqualToStop=true;
                    break;
                }
            }
           if (isListSizeEqualToStop) {
               break;
           }
            rowCounter++;

            // iterate the last row in reversed order
            for (int i = columns - 1; i >= columnsCounter; i--) {
                list.add(list.size(), matrix[rows - 1][i]);
                if (list.size() == stopTheWhile) {
                    isListSizeEqualToStop=true;
                    break;
                }
            }
            if (isListSizeEqualToStop) {
                break;
            }
            rows--;

            //iterate the first columns
            for (int i = rows-1; i >= rowCounter; i--) {
                list.add(list.size(), matrix[i][0+columnsCounter]);
                if (list.size() == stopTheWhile) {
                    break;
                }
            }
            if (isListSizeEqualToStop) {
                break;
            }
            columnsCounter++;
            columns--;

        }
        for (int l : list) {
            System.out.print(l + " ");
        }
    }
}
