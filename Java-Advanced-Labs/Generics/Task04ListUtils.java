package generics;

import java.util.ArrayList;
import java.util.List;

public class ListUtils<T extends Comparable<T>> {
    private List<T> utils;

    public ListUtils() {
        this.utils = new ArrayList<>();
    }

    public static <T extends Comparable<T>> T getMin(List<T> utils) {
        if (utils.isEmpty()) {
            throw new IllegalArgumentException();
        }
        T min = utils.get(0);
        for (int i = 1; i < utils.size(); i++) {
            if (utils.get(i).compareTo(min) < 0) {
                min = utils.get(i);
            }
        }
        return min;

    }
    public static <T extends Comparable<T>> T getMax(List<T> utils) {
        if (utils.isEmpty()) {
            throw new IllegalArgumentException();
        }
        T max = utils.get(0);
        for (int i = 1; i < utils.size(); i++) {
            if (utils.get(i).compareTo(max) > 0) {
                max = utils.get(i);
            }
        }
        return max;

    }
}
