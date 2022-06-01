import java.util.*;

public class e8t5FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Map<String, String> book = new LinkedHashMap<>();
        while (!name.equals("stop")) {
            String email = scanner.nextLine();
            String check = email.substring(email.length()-3).toLowerCase(Locale.ROOT);

            if (!check.contains("uk") && !check.contains("us") && !check.contains("com")) {
                book.putIfAbsent(name, email);
            }

            name = scanner.nextLine();
        }
        for (Map.Entry<String, String> element : book.entrySet()) {
            System.out.printf("%s -> %s%n", element.getKey(), element.getValue());
        }
    }
}
