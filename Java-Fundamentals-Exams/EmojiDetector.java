import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> listOfNumbersForThreshold = new ArrayList<>();
        int threshold = 1;
        extracted(input, listOfNumbersForThreshold);
        threshold = threshold(threshold, listOfNumbersForThreshold);
        System.out.println("Cool threshold: " + threshold);
        Pattern regex = Pattern.compile("(?<name>([*]{2})[A-Z][a-z]{2,}([*]{2})|([:]{2})[A-Z][a-z]{2,}([:]{2}))");
        Matcher matcher = regex.matcher(input);
        List<String> validEmoji = new ArrayList<>();
        listOfValid(matcher, validEmoji);
        List<String> coolEmoji = new ArrayList<>();
        listOfCoolEmoji(validEmoji, coolEmoji, threshold);
        System.out.print(print(validEmoji, coolEmoji));
        for (String s : coolEmoji) {
            System.out.println(s);
        }
    }

    private static void extracted(String input, List<Integer> listOfNumbersForThreshold) {
        for (int i = 0; i < input.length(); i++) {
            char checker = input.charAt(i);
            if (checker > 46 && checker < 58) {
                int checkerToAdd = Integer.parseInt(String.valueOf(checker));
                listOfNumbersForThreshold.add(checkerToAdd);
            }
        }
    }

    private static int threshold(int threshold, List<Integer> listOfNumbersForThreshold) {
        threshold = 1;
        for (int i = 0; i < listOfNumbersForThreshold.size(); i++) {
            threshold *= listOfNumbersForThreshold.get(i);
        }
        return threshold;
    }

    private static void listOfValid(Matcher matcher, List<String> validEmoji) {
        while (matcher.find()) {
            validEmoji.add(matcher.group());
        }
    }

    private static void listOfCoolEmoji(List<String> validEmoji, List<String> coolEmoji, int threshold) {
        int lengthOfEveryValidEmoji = 0;
        int isItCool = 0;
        for (int i = 0; i < validEmoji.size(); i++) {
            lengthOfEveryValidEmoji = validEmoji.get(i).length();
            for (int j = 0; j < lengthOfEveryValidEmoji; j++) {
                char symbol = validEmoji.get(i).charAt(j);
                if ((symbol >= 97 && symbol <= 122) || (symbol >= 65 && symbol <= 90)) {
                    isItCool += symbol;
                }
            }
            if (isItCool > threshold) {
                coolEmoji.add(validEmoji.get(i));
            }
            lengthOfEveryValidEmoji = 0;
            isItCool = 0;
        }

    }
    private static String print(List<String> validEmoji, List<String> coolEmoji) {
        String forPrint = String.format("%d emojis found in the text. The cool ones are: %n", validEmoji.size());
        return forPrint;
    }
}
