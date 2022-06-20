import java.util.*;
import java.util.stream.Collectors;

public class apr13Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] steelInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] carbonInput = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> steel = new ArrayDeque<>();
        ArrayDeque<Integer> carbon = new ArrayDeque<>();
        Map<String, Integer> swords = new TreeMap<>();
        swords.put("Sabre", 0);
        swords.put("Katana", 0);
        swords.put("Shamshir", 0);
        swords.put("Gladius", 0);
        for (int i = 0; i < steelInput.length; i++) {
            steel.add(steelInput[i]);
        }
        for (int i = 0; i < carbonInput.length; i++) {
            carbon.push(carbonInput[i]);
        }
        int counterOfSwords = 0;
        while (!(steel.isEmpty() || carbon.isEmpty())) {
            switch (steel.peek() + carbon.peek()) {
                case 70:
                    steel.poll();
                    carbon.pop();
                    swords.put("Gladius", swords.get("Gladius") + 1);
                    counterOfSwords++;
                    break;
                case 80:
                    steel.poll();
                    carbon.pop();
                    swords.put("Shamshir", swords.get("Shamshir") + 1);
                    counterOfSwords++;
                    break;
                case 90:
                    steel.poll();
                    carbon.pop();
                    swords.put("Katana", swords.get("Katana") + 1);
                    counterOfSwords++;
                    break;
                case 110:
                    steel.poll();
                    carbon.pop();
                    swords.put("Sabre", swords.get("Sabre") + 1);
                    counterOfSwords++;
                    break;
                default:
                    steel.poll();
                    int increase = carbon.pop() + 5;
                    carbon.push(increase);
                    break;
            }
        }
        boolean isEnoughSwords = false;
        if (counterOfSwords > 0) {
            System.out.println("You have forged " + counterOfSwords + " swords.");
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }
        if (steel.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            System.out.print("Steel left: ");
            System.out.print(steel.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }
        if (carbon.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            System.out.print("Carbon left: ");

            System.out.print(carbon.stream().map(String::valueOf).collect(Collectors.joining(", ")));

            System.out.println();
        }
        for (var s : swords.entrySet()) {
            if (s.getValue() > 0) {
                System.out.println(s.getKey() + ": " + s.getValue());
            }
        }
    }
}
