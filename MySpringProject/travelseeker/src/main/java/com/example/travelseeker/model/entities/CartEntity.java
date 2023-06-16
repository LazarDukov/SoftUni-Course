package com.example.travelseeker.model.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "cart")
public class CartEntity extends BaseEntity {
    @OneToOne
    private CategoryEntity category;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    @Column
    private int count;

    @ManyToOne
    private UserEntity user;

    @OneToMany
    private List<HotelEntity> hotels;

    @OneToMany
    private List<CarRentEntity> cars;

    @OneToMany
    private List<AirplaneTicketsEntity> airplaneTickets;

    public CartEntity() {
    }

    public CartEntity(CategoryEntity category,
                      BigDecimal totalPrice,
                      int count,
                      UserEntity user,
                      List<HotelEntity> hotels,
                      List<CarRentEntity> cars,
                      List<AirplaneTicketsEntity> airplaneTickets) {
        this.category = category;
        this.totalPrice = totalPrice;
        this.count = count;
        this.user = user;
        this.hotels = hotels;
        this.cars = cars;
        this.airplaneTickets = airplaneTickets;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public CartEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public CartEntity setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }

    public int getCount() {
        return count;
    }

    public CartEntity setCount(int count) {
        this.count = count;
        return this;
    }

    public UserEntity getUser() {
        return user;
    }

    public CartEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public List<HotelEntity> getHotels() {
        return hotels;
    }

    public CartEntity setHotels(List<HotelEntity> hotels) {
        this.hotels = hotels;
        return this;
    }

    public List<CarRentEntity> getCars() {
        return cars;
    }

    public CartEntity setCars(List<CarRentEntity> cars) {
        this.cars = cars;
        return this;
    }

    public List<AirplaneTicketsEntity> getAirplaneTickets() {
        return airplaneTickets;
    }

    public CartEntity setAirplaneTickets(List<AirplaneTicketsEntity> airplaneTickets) {
        this.airplaneTickets = airplaneTickets;
        return this;
    }
}
