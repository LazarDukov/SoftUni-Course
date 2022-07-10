package Inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArrayList extends ArrayList<Object> {

    public Object getRandomElement() {
        Random random = new Random();

        int index = random.nextInt(super.size());
        return remove(index);
    }
}
