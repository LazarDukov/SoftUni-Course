import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String model = data[0];
            int engineSpeed = Integer.parseInt(data[1]);
            int enginePower = Integer.parseInt(data[2]);
            Engine engine = new Engine(engineSpeed, enginePower);
            int cargoWeight = Integer.parseInt(data[3]);
            String cargoType = data[4];
            double tirePressure1 = Double.parseDouble(data[5]);
            int tireAge1 = Integer.parseInt(data[6]);
            double tirePressure2 = Double.parseDouble(data[7]);
            int tireAge2 = Integer.parseInt(data[8]);
            double tirePressure3 = Double.parseDouble(data[9]);
            int tireAge3 = Integer.parseInt(data[10]);
            double tirePressure4 = Double.parseDouble(data[11]);
            int tireAge4 = Integer.parseInt(data[12]);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire1 = new Tire(tirePressure1, tireAge1);
            Tire tire2 = new Tire(tirePressure1, tireAge1);
            Tire tire3 = new Tire(tirePressure1, tireAge1);
            Tire tire4 = new Tire(tirePressure1, tireAge1);

            Car car = new Car(model, engine, cargo, tire1, tire2, tire3, tire4);
            cars.add(car);
        }
        String typeOfCargo = scanner.nextLine();
        if (typeOfCargo.equals("fragile")) {
            cars.stream().filter(el -> el.getCargo().getCargoType().equals("fragile"))
                    .filter(el -> el.getTire1().getPressure() < 1)
                    .filter(el -> el.getTire2().getPressure() < 1)
                    .filter(el -> el.getTire3().getPressure() < 1)
                    .filter(el -> el.getTire4().getPressure() < 1)
                    .forEach(car -> System.out.println(car.getModel()));
        } else {
            cars.stream().filter(el -> el.getCargo().getCargoType().equals("flamable"))
                    .filter(el -> el.getEngine().getEnginePower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));

        }
    }
}
