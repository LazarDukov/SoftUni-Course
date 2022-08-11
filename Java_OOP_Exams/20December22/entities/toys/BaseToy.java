package catHouse.entities.toys;

public abstract class BaseToy implements Toy {

    //Data
    //•	softness - int
    //•	price - double
    //o	The price of the toy.
    //Constructor
    //A BaseToy should take the following values upon initialization:
    //(int softness, double price)


    private int softness;
    private double price;

    public BaseToy(int softness, double price) {
        this.softness = softness;
        this.price = price;
    }

    @Override
    public int getSoftness() {
        return softness;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
