public class Car {
    String model;
    double fuelAmount;
    double fuelCostFor1km;
    double distanceTravelled;

    public Car(String model, double fuel, double costForOneK, double distanceTravelled) {
        this.model = model;
        this.fuelAmount = fuel;
        this.fuelCostFor1km = costForOneK;
        this.distanceTravelled = distanceTravelled;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getCostForOneK() {
        return fuelCostFor1km;
    }

    public void setCostForOneK(double costForOneK) {
        this.fuelCostFor1km = costForOneK;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }
}
