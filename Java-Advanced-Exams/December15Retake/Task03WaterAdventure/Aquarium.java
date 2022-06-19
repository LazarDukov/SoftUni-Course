package aquarium;

import java.util.*;
import java.util.stream.Collectors;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private Map<String, Fish> fishInPool = new HashMap<>();

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }

    public void add(Fish fish) {
        if (this.capacity > fishInPool.size()) {
            fishInPool.putIfAbsent(fish.getName(), fish);
        }
    }

    public boolean remove(String name) {
        if (this.fishInPool.containsKey(name)) {
            this.fishInPool.remove(name);
            return true;
        }
        return false;
    }

    public Fish findFish(String name) {
        return this.fishInPool.getOrDefault(name, null);

    }

    public String getName() {
        return name;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public String report() {
        StringBuilder text = new StringBuilder();
        for (var f : fishInPool.entrySet()) {
            String result = f.getValue().toString();
            text.append(result + System.lineSeparator());

        }
        String toPrint = text.toString();
        return String.format("Aquarium: %s ^ Size: %d" + System.lineSeparator() + toPrint, this.name, this.size);
    }
}
