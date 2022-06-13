import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        Car car = null;
        for (int i = 0; i < n; i++) {
            String[] inputCar = scanner.nextLine().split("\\s+");
            String model = inputCar[0];
            double fuelAmount = Double.parseDouble(inputCar[1]);
            double fuelCostFor1km = Double.parseDouble(inputCar[2]);
            car = new Car(model, fuelAmount, fuelCostFor1km, 0);
            cars.putIfAbsent(model, car);
        }
        String inputCommands = scanner.nextLine();

        while (!inputCommands.equals("End")) {
            String[] inputCommandsNow = inputCommands.split("\\s+");
            String command = inputCommandsNow[0];
            String model = inputCommandsNow[1];
            double amountOfKiloTravelled = Double.parseDouble(inputCommandsNow[2]);
            if (amountOfKiloTravelled * cars.get(model).getCostForOneK() <= cars.get(model).getFuelAmount()) {
                cars.get(model).setFuelAmount(cars.get(model).getFuelAmount() - amountOfKiloTravelled * cars.get(model).getCostForOneK());
                cars.get(model).setDistanceTravelled(cars.get(model).getDistanceTravelled() + amountOfKiloTravelled);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            inputCommands = scanner.nextLine();
        }
        for (Map.Entry<String, Car> e : cars.entrySet()) {
            System.out.printf("%s %.2f %.0f%n", e.getKey(), e.getValue().fuelAmount, e.getValue().distanceTravelled);
        }

    }
}
