package entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // 	sale (id, product_id, customer_id, store_location_id, date)
    @ManyToOne
    private Product product;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "store_location",
            referencedColumnName = "id")
    private StoreLocation storeLocation;

    @Column
    private LocalDate date;

    public Sale() {
    }

    public Sale(int id, Product product, Customer customer, StoreLocation storeLocation, LocalDate date) {
        this.id = id;
        this.product = product;
        this.customer = customer;
        this.storeLocation = storeLocation;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public StoreLocation getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(StoreLocation storeLocation) {
        this.storeLocation = storeLocation;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
