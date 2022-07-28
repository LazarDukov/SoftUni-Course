package Polymorphism.ExTask01;

import java.text.DecimalFormat;

public class Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {
        double fuelNeeded = distance * fuelConsumption;
        if (fuelNeeded > this.fuelQuantity) {
            return String.format("%s needs refueling", getClass().getSimpleName());
        }
        this.fuelQuantity = this.fuelQuantity - fuelNeeded;
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", getClass().getSimpleName(), df.format(distance));
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
