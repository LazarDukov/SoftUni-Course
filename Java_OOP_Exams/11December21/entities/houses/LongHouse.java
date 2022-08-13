package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.Collection;

public class LongHouse extends BaseHouse {
    private final static int CAPACITY = 30;

    public LongHouse(String name) {
        super(name, CAPACITY);
    }

}
