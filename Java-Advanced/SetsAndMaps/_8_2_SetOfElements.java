import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _8_2_SetOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0];
        int m = input[1];
        Set<Integer> setN = new LinkedHashSet<>();
        Set<Integer> all = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            int nextIntN = Integer.parseInt(scanner.nextLine());
            setN.add(nextIntN);
        }
        for (int i = 0; i < m; i++) {
            int nextIntM = Integer.parseInt(scanner.nextLine());
            if (setN.contains(nextIntM)) {
                all.add(nextIntM);
            }
        }
        for (Integer e : all) {
            System.out.printf("%d ", e);
        }




    }
}
