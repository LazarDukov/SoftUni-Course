package generics;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> content;

    public Jar() {
        this.content = new ArrayDeque<>();
    }

    public void add(T entity) {
        content.push(entity);
    }

    public T remove() {
        return content.pop();
    }
}
