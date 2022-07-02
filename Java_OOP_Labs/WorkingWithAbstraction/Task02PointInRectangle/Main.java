package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputRectanglePoints = input(scanner);
        int bottomLeftX = inputRectanglePoints[0];
        int bottomLeftY = inputRectanglePoints[1];
        int topRightX = inputRectanglePoints[2];
        int topRightY = inputRectanglePoints[3];

        Rectangle rectangle = new Rectangle(bottomLeftX, bottomLeftY, topRightX, topRightY);

        int numberCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberCommands; i++) {

            int[] inputPointsData = input(scanner);
            int x = inputPointsData[0];
            int y = inputPointsData[1];

            Point point = new Point(x, y);
            System.out.println(rectangle.contains(point));
        }
    }

    public static int[] input(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
