import java.util.*;
import java.util.Scanner;

public class CarSalesman {
    static class Car {
        //A Car has a model, engine, weight, and color. An Engine has a model, power, displacement, and efficiency.

        private String model;
        private Engine engine;
        private String weight;
        private String color;


        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public Engine getEngine() {
            return engine;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        Car(String model, Engine engine, String weight, String color) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.color = color;
        }

        @Override
        public String toString() {
            //{CarModel}:
            //  {EngineModel}:
            //    Power: {EnginePower}
            //    Displacement: {EngineDisplacement}
            //    Efficiency: {EngineEfficiency}
            //  Weight: {CarWeight}
            //  Color: {CarColor}
            return String.format("%s:%n" +
                                 "  %s" +
                                 "  Weight: %s%n" +
                                 "  Color: %s", getModel(), getEngine().toString(), getWeight(), getColor());
        }
    }

    static class Engine {
        private String model;
        private String power;
        private String displacement;
        private String efficiency;


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

        Engine(String model, String power, String displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        @Override
        public String toString() {
            return String.format("%s:%n" +
                    "    Power: %s%n" +
                    "    Displacement: %s%n" +
                    "    Efficiency: %s%n", getModel(), getPower(), getDisplacement(), getEfficiency());
        }

    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        //A Car’s weight and color and its Engine’s displacements and efficiency are optional.
        List<Engine> engines = new ArrayList<>();
        String input;
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input = console.nextLine();
            String[] engineInput = input.split("\\s+");
            String model = engineInput[0];
            String power = engineInput[1];
            String displacement = "n/a";
            String efficiency = "n/a";
            if (engineInput.length == 3) {
                if (engineInput[2].matches("-?\\d+")) {
                    displacement = engineInput[2];
                } else {
                    efficiency = engineInput[2];
                }
            } else if (engineInput.length == 4) {
                displacement = engineInput[2];
                efficiency = engineInput[3];
            }
            Engine singleEngine = new Engine(model, power, displacement, efficiency);
            engines.add(singleEngine);
        }
        int m = Integer.parseInt(console.nextLine());
        for (int i = 0; i < m; i++) {
            input = console.nextLine();
            String[] carInput = input.split("\\s+");
            String model = carInput[0];
            String engine = carInput[1];
            String weight = "n/a";
            String color = "n/a";
            if (carInput.length == 3) {
                if (carInput[2].matches("-?\\d+")) {
                    weight = carInput[2];
                } else {
                    color = carInput[2];
                }
            } else if (carInput.length == 4) {
                weight = carInput[2];
                color = carInput[3];
            }
            String newModel = null;
            String newPower = null;
            String newDisplacement = null;
            String newEfficiency = null;
            for (Engine oneEngine : engines) {
                if (oneEngine.getModel().equals(engine)) {
                    newModel = oneEngine.getModel();
                    newPower = oneEngine.getPower();
                    newDisplacement = oneEngine.getDisplacement();
                    newEfficiency = oneEngine.getEfficiency();
                    break;
                }
            }
            Engine engineForThisCar = new Engine(newModel, newPower, newDisplacement, newEfficiency);
            Car car = new Car(model, engineForThisCar, weight, color);
            cars.add(car);
        }
        cars.forEach(car -> System.out.println(car.toString()));
    }
}
