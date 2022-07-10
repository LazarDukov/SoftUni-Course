package Inheritance;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data = new ArrayList<>();

    public void push(String item) {
        data.add(item);
    }

    public String pop() {
        String myString = data.get(data.size() - 1);
        data.remove(data.size() - 1);
        return myString;
    }

    public String peek() {
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }


    //•	Private field: data: ArrayList<String>
    //•	Public method: push(String item): void
    //•	Public method: pop(): String
    //•	Public method: peek(): String
    //•	Public method: isEmpty(): boolean
}
