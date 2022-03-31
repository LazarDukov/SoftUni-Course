

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Pattern words = Pattern.compile("([@#])\\b(?<firstWord>[A-Za-z]{3,})\\b(\\1\\1)\\b(?<secondWord>[A-Za-z]{3,})\\b\\1");
        Matcher matcher = words.matcher(line);
        List<String> matchedWordsFirst = new ArrayList<>();
        List<String> matchedWordsSecond = new ArrayList<>();
        int counter = 0;
        while (matcher.find()) {
            matchedWordsFirst.add(matcher.group("firstWord"));
            matchedWordsSecond.add(matcher.group("secondWord"));
            counter += 1;
        }
        if (counter > 0) {
            System.out.println(counter + " word pairs found!");
        } else {
            System.out.println("No word pairs found!");
        }
        List<String> mirrorWords = new ArrayList<>();
        for (int i = 0; i < matchedWordsFirst.size(); i++) {
            String wordOne = matchedWordsFirst.get(i);
            String wordTwo = matchedWordsSecond.get(i);
            // StringBuilder reversed = new StringBuilder(wordTwo);
            //  reversed.reverse();
            counter = 0;
            if (wordOne.length() == wordTwo.length()) {
                for (int j = 0; j < wordOne.length(); j++) {

                    char one = wordOne.charAt(j);
                    char two = wordTwo.charAt(wordTwo.length() - j - 1);
                    if (one == two) {
                        counter++;
                    }
                    if (counter == wordOne.length()) {
                        mirrorWords.add(wordOne + " <=> " + wordTwo);
                    }
                }
                counter = 0;

            }
        }
        if (mirrorWords.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", mirrorWords));
        }
    }
}
