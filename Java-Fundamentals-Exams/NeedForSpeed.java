import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class NeedForSpeed {
    public static class Car {
        int mileage;
        int fuel;

        public Car(int mileage, int fuel) {
            this.mileage = mileage;
            this.fuel = fuel;
        }

        public int getMileage() {
            return mileage;
        }

        public void setMileage(int mileage) {
            this.mileage = mileage;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        Map<String, Car> carWithFuel = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = console.nextLine().split("[|]");
            String carKey = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            Car car = new Car(mileage, fuel);
            carWithFuel.put(carKey, new Car(mileage, fuel));

        }
        String newLine = console.nextLine();
        while (!newLine.equals("Stop")) {
            String[] newLineInfo = newLine.split("\\b : \\b");
            String command = newLineInfo[0];
            String carModel = newLineInfo[1];
            int getFuelOfCar = carWithFuel.get(carModel).getFuel();
            int getDistanceOfCar = carWithFuel.get(carModel).getMileage();
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(newLineInfo[2]);
                    int fuel = Integer.parseInt(newLineInfo[3]);
                    if (getFuelOfCar > fuel) {
                        carWithFuel.get(carModel).setMileage(getDistanceOfCar + distance);
                        carWithFuel.get(carModel).setFuel(carWithFuel.get(carModel).getFuel() - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", carModel, distance, fuel);
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    if (carWithFuel.get(carModel).getMileage() >= 100000) {
                        carWithFuel.remove(carModel);
                        System.out.printf("Time to sell the %s!%n", carModel);
                    }
                    break;
                case "Refuel":
                    int newAmountFuel = Integer.parseInt(newLineInfo[2]);
                    int colAdded = 0;
                    if (newAmountFuel + getFuelOfCar > 75) {
                        colAdded = 75 - getFuelOfCar;
                        carWithFuel.get(carModel).setFuel(carWithFuel.get(carModel).getFuel() + colAdded);
                        System.out.printf("%s refueled with %d liters%n", carModel, colAdded);
                    } else {
                        colAdded = newAmountFuel;
                        carWithFuel.get(carModel).setFuel(carWithFuel.get(carModel).getFuel() + newAmountFuel);
                        System.out.printf("%s refueled with %d liters%n", carModel, newAmountFuel);
                    }
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(newLineInfo[2]);

                    if (carWithFuel.get(carModel).getMileage() - kilometers < 10000) {
                        carWithFuel.get(carModel).setMileage(10000);
                    } else {
                        carWithFuel.get(carModel).setMileage(carWithFuel.get(carModel).getMileage() - kilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", carModel, kilometers);
                    }
                    break;
            }
            newLine = console.nextLine();
        }
        for (Map.Entry<String, Car> entry : carWithFuel.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", entry.getKey(), entry.getValue().mileage, entry.getValue().fuel);
        }
    }
}
