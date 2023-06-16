package com.example.travelseeker.model.entities;

import com.example.travelseeker.model.enums.CarBodyTypeEnum;
import com.example.travelseeker.model.enums.CarFuelTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table
public class CarRentEntity extends BaseEntity {
    @Column
    private String make;

    @Column
    private String model;

    @Column
    private CarBodyTypeEnum bodyType;

    @Column
    private CarFuelTypeEnum fuelType;

    @Column
    private BigDecimal price;

    @Column
    private BigDecimal insurance;

    @ManyToOne
    private BoughtOffersEntity cart;

    public CarRentEntity() {
    }

    public CarRentEntity(String make,
                         String model,
                         CarBodyTypeEnum bodyType,
                         CarFuelTypeEnum fuelType,
                         BigDecimal price,
                         BigDecimal insurance,
                         BoughtOffersEntity cart) {
        this.make = make;
        this.model = model;
        this.bodyType = bodyType;
        this.fuelType = fuelType;
        this.price = price;
        this.insurance = insurance;
        this.cart = cart;
    }

    public String getMake() {
        return make;
    }

    public CarRentEntity setMake(String make) {
        this.make = make;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarRentEntity setModel(String model) {
        this.model = model;
        return this;
    }

    public CarBodyTypeEnum getBodyType() {
        return bodyType;
    }

    public CarRentEntity setBodyType(CarBodyTypeEnum bodyType) {
        this.bodyType = bodyType;
        return this;
    }

    public CarFuelTypeEnum getFuelType() {
        return fuelType;
    }

    public CarRentEntity setFuelType(CarFuelTypeEnum fuelType) {
        this.fuelType = fuelType;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CarRentEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getInsurance() {
        return insurance;
    }

    public CarRentEntity setInsurance(BigDecimal insurance) {
        this.insurance = insurance;
        return this;
    }

    public BoughtOffersEntity getCart() {
        return cart;
    }

    public CarRentEntity setCart(BoughtOffersEntity cart) {
        this.cart = cart;
        return this;
    }
}
