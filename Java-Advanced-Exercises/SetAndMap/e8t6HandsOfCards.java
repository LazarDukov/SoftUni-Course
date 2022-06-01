import java.util.*;

public class e8t6HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Set<String>> players = new LinkedHashMap<>();
        //   Map<String, Integer> finalist = new HashMap<>();
        while (!input.equals("JOKER")) {
            String[] dataFromInput = input.split(": ");
            String name = dataFromInput[0];
            String[] values = dataFromInput[1].split(", ");
            if (!players.containsKey(name)) {
                players.putIfAbsent(name, new HashSet<>());
                for (int i = 0; i < values.length; i++) {
                    players.get(name).add(values[i]);
                }
            } else {
                for (int i = 0; i < values.length; i++) {
                    players.get(name).add(values[i]);
                }
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, Set<String>> el : players.entrySet()) {
            String name = el.getKey();
            int power = 0;
            int multiplier = 0;
            int sum = 0;
            for (var value : el.getValue()) {
                String newValue = value.substring(0, value.length() - 1);
                if (newValue.equals("J")) {
                    power = 11;
                } else if (newValue.equals("Q")) {
                    power = 12;
                } else if (newValue.equals("K")) {
                    power = 13;
                } else if (newValue.equals("A")) {
                    power = 14;
                } else {
                    power = Integer.parseInt(newValue);
                }
                if (value.substring(value.length() - 1).equals("S")) {
                    multiplier = 4;
                } else if (value.substring(value.length() - 1).equals("H")) {
                    multiplier = 3;
                } else if (value.substring(value.length() - 1).equals("D")) {
                    multiplier = 2;
                } else if (value.substring(value.length() - 1).equals("C")) {
                    multiplier = 1;
                }
                sum += multiplier * power;
            }
            System.out.printf("%s: %d%n", name, sum);
        }
        System.out.println();
    }
}