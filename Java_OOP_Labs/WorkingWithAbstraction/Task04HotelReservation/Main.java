package HotelReservation;

import java.beans.IntrospectionException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        Double pricePerDay = Double.parseDouble(input[0]);
        int days = Integer.parseInt(input[1]);
        Season season = Season.valueOf(input[2]);
        DiscountType discountType = DiscountType.valueOf(input[3]);
        double priceCalculator = PriceCalculator.calculator(pricePerDay, days, season, discountType);
        System.out.printf("%.2f", priceCalculator);
    }
}
