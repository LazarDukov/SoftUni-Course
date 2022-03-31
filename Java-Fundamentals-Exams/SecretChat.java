import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder text = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {

            String[] command = input.split("[:|:]+");
            String whatToDo = command[0];
            switch (whatToDo) {
                case "InsertSpace": //insert a space at the given index
                    int index = Integer.parseInt(command[1]);
                    text.insert(index, " ");
                    System.out.println(text);
                    break;
                case "Reverse": //gets substring who is contained, cut it and add in the end of the line
                    String wordToSearch = command[1];
                    int indexOfSymbolToCut = text.indexOf(wordToSearch);
                    String message = text.toString();
                    if (message.contains(wordToSearch)) {
                        String toReverse = new StringBuilder(wordToSearch).reverse().toString();
                        message = message.replaceFirst(Pattern.quote(wordToSearch), "") + toReverse;
                        System.out.println(message);
                        text = new StringBuilder(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll": //change all symbols with replacement text
                   String oldValue = command[1];
                   String newValue = command[2];
                        text.replace(0, text.length(), text.toString().replace(oldValue, newValue));
                    System.out.println(text);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + text);
    }
}
