import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WorldTour02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder destinationToChange = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Travel")) {
            String[] inputLine = input.split("\\:");
            String command = inputLine[0];
            input = scanner.nextLine();
            switch (command) {
                case "Add Stop":
                    int indexInput = Integer.parseInt(inputLine[1]);
                    String stringToInsert = inputLine[2];
                    boolean isValid = false;
                    if (indexInput > -1 && indexInput < destinationToChange.length()) {
                        isValid = true;

                        destinationToChange.insert(indexInput, stringToInsert);
                    }
                    System.out.println(destinationToChange);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(inputLine[1]);
                    int endIndex = Integer.parseInt(inputLine[2]);
                    if (startIndex > -1 && startIndex < destinationToChange.length() && endIndex < destinationToChange.length()) {

                        destinationToChange.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(destinationToChange);
                    break;
                case "Switch":
                    String oldWord = inputLine[1];
                    String newWord = inputLine[2];
                 if (destinationToChange.toString().contains(oldWord)) {
                     destinationToChange = new StringBuilder(destinationToChange.toString().replace(oldWord, newWord));
                 }
                    System.out.println(destinationToChange);
                    break;
            }

        }
        System.out.println("Ready for world tour! Planned stops: " + destinationToChange);
    }
}
