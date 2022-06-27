package generics;

import java.util.*;

public class Box<T extends Comparable<T>> {
    private List<T> data;

    public Box() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
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

    public void swap(int firstIndex, int secondIndex) {
        T temp = data.get(firstIndex);
        data.set(firstIndex, data.get(secondIndex));
        data.set(secondIndex, temp);

    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T d : this.data) {
            if (d.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T remove(int index) {
        return this.data.remove(index);

    }

    public boolean contains(T element) {
        if (this.data.contains(element)) {
            return true;
        }
        return false;
    }

    public T getMax() {
        return this.data.stream().max(Comparable::compareTo).orElseGet(null);
    }

    public T getMin() {
        return this.data.stream().min(Comparable::compareTo).orElseGet(null);
    }

    public void print() {
        this.data.forEach(System.out::println);
    }

    public void sort() {
        Collections.sort(this.data);
    }
    //•	T remove(int index)
    //•	boolean contains(T element)
    //•	int countGreaterThan(T element)
    //•	T getMax()
    //•	T getMin()
}
