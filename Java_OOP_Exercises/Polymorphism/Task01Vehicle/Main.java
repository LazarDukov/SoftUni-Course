package Polymorphism.ExTask01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInput = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carInput[1]), Double.parseDouble(carInput[2]));
        String[] truckInput = scanner.nextLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckInput[1]), Double.parseDouble(truckInput[2]));
        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandsInput = scanner.nextLine().split("\\s+");

            String command = commandsInput[0];
            String vehicle = commandsInput[1];
            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(commandsInput[2]);
                    if ("Car".equals(vehicle)) {
                        System.out.println(car.drive(distance));
                    } else {
                        System.out.println(truck.drive(distance));
                    }
                    break;
                case "Refuel":
                    double fuel = Double.parseDouble(commandsInput[2]);
                    if ("Car".equals(vehicle)) {
                        car.refuel(fuel);
                    } else {
                        truck.refuel(fuel);
                    }
                    break;
            }
        }
        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
    }
}
