import java.util.*;
import java.util.stream.Collectors;

public class feb22FoodFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> word = new LinkedHashMap<>();
        List<String> matchedSymbols = new ArrayList<>();
        List<String> symbols = new ArrayList<>();
        List<String> matchedWords = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<String> inputSymbols = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
            symbols.addAll(inputSymbols);
        }
        word.putIfAbsent("pear", new ArrayList<>());
        word.get("pear").addAll(symbols);
        word.putIfAbsent("flour", new ArrayList<>());
        word.get("flour").addAll(symbols);
        word.putIfAbsent("pork", new ArrayList<>());
        word.get("pork").addAll(symbols);
        word.putIfAbsent("olive", new ArrayList<>());
        word.get("olive").addAll(symbols);
        for (Map.Entry<String, List<String>> element : word.entrySet()) {
            String checkWord = element.getKey();
            for (int i = 0; i < word.get(checkWord).size(); i++) {
                String charToCheck = element.getValue().get(i);
                if (checkWord.contains(charToCheck)) {
                    matchedSymbols.add(charToCheck);
                    for (int j = 0; j < word.get(checkWord).size(); j++) {
                        if (charToCheck.equals(word.get(checkWord).get(j))) {
                            word.get(checkWord).remove(word.get(checkWord).get(j));
                        }
                    }


                    i--;
                }
                if (matchedSymbols.size() == checkWord.length()) {
                    matchedWords.add(checkWord);
                    matchedSymbols = new ArrayList<>();
                }

            }
            matchedSymbols = new ArrayList<>();
        }
        System.out.printf("Words found: %d%n", matchedWords.size());
        matchedWords.forEach(System.out::println);
    }
}
