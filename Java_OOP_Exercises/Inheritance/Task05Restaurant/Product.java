package restaurant;

import java.math.BigDecimal;

public class Product {
    //•	A public constructor with the following parameters: String name, BigDecimal price
    //•	name – String
    //•	price - BigDecimal
    //•	Getters for the fields
    private String name;
    private BigDecimal price;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    //Beverage and Food classes are products. The Beverage class must have the following members:
    //•	A public constructor with the following parameters: String name, BigDecimal price, double milliliters
    //•	name – String
    //•	price – BigDecimal
    //•	milliliters - double
    //•	Getter for milliliters
}
