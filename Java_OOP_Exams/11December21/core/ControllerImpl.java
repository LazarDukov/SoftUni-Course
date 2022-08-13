package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {

    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house = null;
        if (type.equals("ShortHouse")) {
            house = new ShortHouse(name);
        } else if (type.equals("LongHouse")) {
            house = new LongHouse(name);
        } else {
            throw new NullPointerException(INVALID_HOUSE_TYPE);
        }
        houses.add(house);
        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy = null;
        if (type.equals("Mouse")) {
            toy = new Mouse();
        } else if (type.equals("Ball")) {
            toy = new Ball();
        } else {
            throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);
        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }
        House house = houses.stream().filter(house1 -> house1.getName().equals(houseName)).findFirst().orElse(null);

        house.buyToy(toy);
        toys.removeToy(toy);
        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat = null;
        if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else if ((catType.equals("ShorthairCat"))) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }
        House house = houses.stream().filter(house1 -> house1.getName().equals(houseName)).findFirst().orElse(null);
        if ((house.getClass().getSimpleName().equals("LongHouse") && catType.equals("LonghairCat"))
                || (house.getClass().getSimpleName().equals("ShortHouse") && catType.equals("ShorthairCat"))) {
            house.addCat(cat);
            return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
        } else {
            throw new IllegalArgumentException(UNSUITABLE_HOUSE);
        }

    }


    @Override
    public String feedingCat(String houseName) {
        House h = houses.stream().filter(house -> house.getName().equals(houseName)).findFirst().orElse(null);
        h.feeding();
        int catsCounter = h.getCats().size();
        return String.format(FEEDING_CAT, catsCounter);
    }

    @Override
    public String sumOfAll(String houseName) {
        House h = houses.stream().filter(house -> house.getName().equals(houseName)).findFirst().orElse(null);
        double allCatPrice = h.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double allToyPrice = h.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double value = allCatPrice + allToyPrice;

        return String.format(VALUE_HOUSE, houseName, value);
    }

    @Override
    public String getStatistics() {
        return houses.stream().map(House::getStatistics).collect(Collectors.joining(System.lineSeparator()));
    }
}
