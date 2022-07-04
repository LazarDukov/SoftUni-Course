package HotelReservation;

public enum DiscountType {
    //•	20% for VIP clients - VIP
    //•	10% for clients, visiting for a second time - SecondVisit
    //•	0% if there is no discount - None
    VIP(0.80),
    SecondVisit(0.90),
    None(1);

    double discount;

    DiscountType(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
