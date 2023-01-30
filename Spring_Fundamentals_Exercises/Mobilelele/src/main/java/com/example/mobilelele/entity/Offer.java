package com.example.mobilelele.entity;

import com.example.mobilelele.Utils.Engine;
import com.example.mobilelele.Utils.Transmission;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class Offer extends BaseEntity{
    //•	description – some text.
    //•	engine – enumerated value (GASOLINE, DIESEL, ELECTRIC, HYBRID).
    //•	imageUrl – the url of image.
    //•	mileage – a number.
    //•	price – the price of the offer.
    //•	transmission – enumerated value (MANUAL, AUTOMATIC).
    //•	year – the year of offered car.
    //•	created – a date and time.
    //•	modified – a date and time.
    //•	model – the model of a car.
    //•	seller – a user that sells the car.
    @Column
    private String description;

    @Enumerated
    private Engine engine;

    @Column(name = "image_url")
    private String imageUrl;

    @Column
    private int mileage;

    @Column
    private double price;

    @Column
    private Transmission transmission;

    @Column
    private String year;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime modified;

    @OneToOne
    private Model model;

    @ManyToOne
    private User user;

    public Offer() {
    }

    public Offer(String description, Engine engine, String imageUrl, int mileage, double price, Transmission transmission, String year, LocalDateTime created, LocalDateTime modified, Model model, User user) {
        this.description = description;
        this.engine = engine;
        this.imageUrl = imageUrl;
        this.mileage = mileage;
        this.price = price;
        this.transmission = transmission;
        this.year = year;
        this.created = created;
        this.modified = modified;
        this.model = model;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
