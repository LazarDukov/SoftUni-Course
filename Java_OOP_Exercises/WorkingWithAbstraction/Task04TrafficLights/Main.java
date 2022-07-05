package TrafficLight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < input.length; j++) {
                String currentColor = input[j];
                currentColor = changeColor(input, currentColor);
                input[j] = currentColor;
            }
            printLight(input);
        }

    }

    public static String changeColor(String[] input, String currentColor) {
        switch (currentColor) {
            case "RED":
                currentColor = TrafficLight.GREEN.name();
                break;
            case "GREEN":
                currentColor = TrafficLight.YELLOW.name();
                break;
            case "YELLOW":
                currentColor = TrafficLight.RED.name();
                break;
        }
        return currentColor;
    }

    public static void printLight(String[] input) {
        for (var l : input) {
            System.out.print(l + " ");
        }
        System.out.println();
    }
}