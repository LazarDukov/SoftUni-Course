import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //•	"Shadowmourne" - requires 250 Shards
        //•	"Valanyr" - requires 250 Fragments
        //•	"Dragonwrath" - requires 250 Motes
        Map<String, Integer> data = new LinkedHashMap<>();
        int shards = 0;
        int fragments = 0;
        int motes = 0;
        data.put("shards", shards);
        data.put("fragments", fragments);
        data.put("motes", motes);
        while (shards < 250 && fragments < 250 && motes < 250) {
            String[] input = sc.nextLine().split("\\s+");
            for (int i = 0; i < input.length - 1; i += 2) {
                String material = input[i + 1].toLowerCase();
                int quantity = Integer.parseInt(input[i]);
                data.putIfAbsent(material, 0);
                //  data.put(material, data.get(material) + quantity);
                if (material.equals("shards")) {
                    data.put(material, data.get(material) + quantity);
                    shards += quantity;
                    if (shards >= 250) {
                        System.out.println("Shadowmourne obtained!");
                        data.put(material, shards - 250);
                        break;
                    }
                } else if (material.equals("fragments")) {
                    data.put(material, data.get(material) + quantity);
                    fragments += quantity;
                    if (fragments >= 250) {
                        System.out.println("Valanyr obtained!");
                        data.put(material, fragments - 250);
                        break;
                    }
                } else if (material.equals("motes")) {
                    data.put(material, data.get(material) + quantity);
                    motes += quantity;
                    if (motes >= 250) {
                        System.out.println("Dragonwrath obtained!");
                        data.put(material, motes - 250);
                        break;
                    }
                } else {
                    data.put(material, data.get(material) + quantity);
                }
            }
        }
        data.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
