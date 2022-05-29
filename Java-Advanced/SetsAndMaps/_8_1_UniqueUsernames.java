import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _8_1_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> set = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
           String input = scanner.nextLine();
           set.add(input);
        }
        for (String e : set) {
            System.out.println(e);
        }
    }
}
