package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.Collection;

public class ShortHouse extends BaseHouse {
    private final static int CAPACITY = 15;

    public ShortHouse(String name) {
        super(name, CAPACITY);
    }
}
