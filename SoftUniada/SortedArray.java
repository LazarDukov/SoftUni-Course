import java.sql.Array;
import java.util.Scanner;

public class SortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(scanner.next());
        }
        for (int i = 0; i < n-1; i++) {
            if (i == 0) {
                if (arr[0] < arr[1]) {
                    int newNumberForNull = arr[0];
                    arr[0] = arr[1];
                    arr[1] = newNumberForNull;

                }
            }
            if (i > 0 && i % 2 != 0) {
                if (arr[i] > arr[i - 1] || arr[i] > arr[i + 1]) {
                    int newNumber = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = newNumber;

                }
            }
            if (i > 0 && i % 2 == 0) {
                if (arr[i] < arr[i - 1] || arr[i] < arr[i + 1]) {
                    int newNumber = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = newNumber;

                }
            }

        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
