import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class e8t4PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> phoneBook = new HashMap<>();
        while (!input.equals("search")) {
            String[] dataIn = input.split("[-]");
            String name = dataIn[0];
            String phoneNumber = dataIn[1];
            if (!phoneBook.containsKey(name)) {
                phoneBook.putIfAbsent(name, phoneNumber);
            } else {
                phoneBook.put(name, phoneNumber);
            }
            input = scanner.nextLine();
        }
        String nameToPrint = scanner.nextLine();
        while (!nameToPrint.equals("stop")) {


            for (Map.Entry<String, String> s : phoneBook.entrySet()) {
                if (s.getKey().equals(nameToPrint)) {
                    System.out.printf("%s -> %s%n", s.getKey(), s.getValue());
                } else {
                    System.out.printf("Contact %s does not exist.%n", nameToPrint);
                }

                nameToPrint = scanner.nextLine();
            }

        }
    }
}