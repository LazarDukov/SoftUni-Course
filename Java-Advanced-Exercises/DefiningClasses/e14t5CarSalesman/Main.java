import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> allEngines = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] engineData = scanner.nextLine().split("\\s+");
            String model = engineData[0];
            String power = engineData[1];

            Engine engine = null;
            switch (engineData.length) {
                case 2:
                    engine = new Engine(model, power);
                    break;
                case 3:
                    String displacementOrEfficiency = engineData[2];
                    engine = new Engine(model, power, displacementOrEfficiency);
                    break;
                case 4:
                    String displacement = engineData[2];
                    String efficiency = engineData[3];
                    engine = new Engine(model, power, displacement, efficiency);
                    break;


            }
            allEngines.put(model, engine);

        }
        int m = Integer.parseInt(scanner.nextLine());
        List<Car> allCars = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            String[] carData = scanner.nextLine().split("\\s+");
            String model = carData[0];
            String modelOfEngine = carData[1];
            Engine engine = allEngines.get(modelOfEngine);
            Car car = null;

            switch (carData.length) {
                case 2:
                    car = new Car(model, engine);
                    break;
                case 3:
                    String weightOrColor = carData[2];
                    car = new Car(model, engine, weightOrColor);
                    break;
                case 4:
                    String weight = carData[2];
                    String color = carData[3];
                    car = new Car(model, engine, weight, color);
                    break;


            }
            allCars.add(car);

        }
        for (var c : allCars) {
            System.out.println(c);
        }

    }
}
