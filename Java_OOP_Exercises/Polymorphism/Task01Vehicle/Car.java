package Polymorphism.ExTask01;

public class Car extends Vehicle {
    private static final double AC_CONSUMPTION_ADDED = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AC_CONSUMPTION_ADDED);

    }

}
