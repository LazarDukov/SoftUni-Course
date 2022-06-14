public class Engine {

    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    public Engine(String model, String power) {
        this.model = model;
        this.power = power;
        this.displacement = "n/a";
        this.efficiency = "n/a";
    }

    public Engine(String model, String power, String displacementOrEfficiency) {
        this(model, power);
        if (displacementOrEfficiency.charAt(0) >= 48 && displacementOrEfficiency.charAt(0) <= 57)  {
            this.displacement = displacementOrEfficiency;
        } else {
            this.efficiency = displacementOrEfficiency;
        }

    }

    public Engine(String model, String power, String displacement, String efficiency) {
        this(model, power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    public String engineToPrint() {
        return String.format("Power: %s%n" +
                "Displacement: %s%n" +
                "Efficiency: %s%n", this.power, this.displacement, this.efficiency);
    }
}
