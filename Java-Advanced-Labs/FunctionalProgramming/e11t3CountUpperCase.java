import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class e11t3CountUpperCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> words = w -> Character.isUpperCase(w.charAt(0));
        List<String> wordsUpperCase = Arrays.stream(scanner.nextLine().split(" "))
                .filter(words).collect(Collectors.toList());
        System.out.println(wordsUpperCase.size());
        System.out.println(String.join("\n", wordsUpperCase));

    }
}
