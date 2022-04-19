import java.util.*;

public class Pirates {
    public static class Target {
        String name;
        List<Integer> info;

        public Target(String name, List<Integer> info) {
            this.name = name;
            this.info = info;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Integer> getInfo() {
            return info;
        }

        public void setInfo(List<Integer> info) {
            this.info = info;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, List<Integer>> targets = new LinkedHashMap<>();
int count = 0;
        while (!input.equals("Sail")) {
            String[] arrInput = input.split("([||]+)");
            String keyName = arrInput[0];
            int valuePopulation = Integer.parseInt(arrInput[1]);
            int valueGold = Integer.parseInt(arrInput[2]);
            if (targets.containsKey(keyName)) {
                targets.get(keyName).set(0, targets.get(keyName).get(0) + valuePopulation);
                targets.get(keyName).set(1, targets.get(keyName).get(1) + valueGold);
            } else {
                count += 1;
                targets.put(keyName, new ArrayList<>());
                targets.get(keyName).add(0, valuePopulation);
                targets.get(keyName).add(1, valueGold);
            }
            input = scanner.nextLine();
        }
        String input2 = scanner.nextLine();
        while (!input2.equals("End")) {
            String[] arrInput2 = input2.split("[=>]+");
            String command = arrInput2[0];
            String keyName = arrInput2[1];
            switch (command) {
                case "Plunder":
                    int valuePopulation = Integer.parseInt(arrInput2[2]);
                    int valueGold = Integer.parseInt(arrInput2[3]);
                    if (targets.get(keyName).get(0) - valuePopulation <= 0 || targets.get(keyName).get(1) - valueGold <= 0) {
                        targets.remove(keyName);
                        count -= 1;
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", keyName, valueGold, valuePopulation);
                        System.out.println(keyName + " has been wiped off the map!");
                    } else {
                        targets.get(keyName).set(0, targets.get(keyName).get(0) - valuePopulation);
                        targets.get(keyName).set(1, targets.get(keyName).get(1) - valueGold);
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", keyName, valueGold, valuePopulation);

                    }
                    break;
                case "Prosper":
                    int valueGoldAdd = Integer.parseInt(arrInput2[2]);
                    if (valueGoldAdd > 0) {
                        targets.get(keyName).set(1, targets.get(keyName).get(1) + valueGoldAdd);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", valueGoldAdd, keyName, targets.get(keyName).get(1));
                    } else {
                        System.out.println("Gold added cannot be a negative number!");
                    }
                    break;
            }
            input2 = scanner.nextLine();
        }
        System.out.println("Ahoy, Captain! There are " + count + " wealthy settlements to go to: ");
        if (count > 0) {
            for (Map.Entry<String, List<Integer>> entry : targets.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }
}
