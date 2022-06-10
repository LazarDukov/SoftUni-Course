import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleCount = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> persons = new TreeMap<>();
        for (int i = 0; i < peopleCount; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            persons.put(name, age);
        }
        for (Map.Entry<String, Integer> person : persons.entrySet()) {
            if (person.getValue() > 30) {
                System.out.printf("%s - %d%n", person.getKey(), person.getValue());
            }

        }
    }
}
