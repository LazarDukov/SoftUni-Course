import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ForceBook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> forceBookInfo = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!input.equals("Lumpawaroo")) {
            if (input.contains("|")) {
                String[] inputSideUser = input.split("\\s+\\|\\s++");
                String side = inputSideUser[0];
                String user = inputSideUser[1];
                forceBookInfo.putIfAbsent(side, new ArrayList<>());
                forceBookInfo.get(side).add(user);
                boolean noneMatch = forceBookInfo.entrySet().stream().noneMatch(value -> value.getValue().contains(user));
                if (noneMatch) {
                    forceBookInfo.get(side).add(user);
                }
            } else if (input.contains("->")) {

                String[] inputUserSide = input.split("\\s+\\->\\s++");
                String user = inputUserSide[0];
                String side = inputUserSide[1];
                forceBookInfo.forEach((k,v) -> v.remove(user));
                forceBookInfo.putIfAbsent(side, new ArrayList<>());
                forceBookInfo.get(side).add(user);
                System.out.println(user + " joins the " + side + " side!");
            }

            input = sc.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : forceBookInfo.entrySet()) {
            if (entry.getValue().size()>=1) {
                System.out.printf("Side: %s, Members: %d%n", entry.getKey(),entry.getValue().size());

                for (String value : entry.getValue() ) {
                    System.out.printf("! %s%n", value);
                }
            }
        }
    }
}
