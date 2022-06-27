package generics;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private List<String> data;

    public Box() {
        this.data = new ArrayList<>();
    }

    public void add(String element) {
        this.data.add(element);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (var value : data) {
            stringBuilder.append(String.format("%s: %s%n", value.getClass().getName(), value.toString()));
        }
        return stringBuilder.toString();
    }
}
