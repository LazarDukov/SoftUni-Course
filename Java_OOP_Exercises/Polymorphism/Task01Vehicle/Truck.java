package Polymorphism.ExTask01;

public class Truck extends Vehicle {
    private static final double AC_CONSUMPTION_ADDED = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + AC_CONSUMPTION_ADDED);
    }

    @Override
    public void refuel(double liters) {
        liters = liters * 0.95;
        super.refuel(liters);
    }
}
