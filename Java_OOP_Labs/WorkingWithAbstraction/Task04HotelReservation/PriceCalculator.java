package HotelReservation;

public class PriceCalculator {
    public static double calculator(Double pricePerDay, int days, Season season, DiscountType discountType) {
        double finalPriceWithoutDiscount = pricePerDay * days * season.getMulti();
        return finalPriceWithoutDiscount * discountType.discount;
    }
}
