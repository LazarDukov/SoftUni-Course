package com.example.travelseeker.model.entities;

import com.example.travelseeker.model.enums.HotelRoomEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.math.BigDecimal;

@Entity
@Table
public class HotelEntity extends BaseEntity {
    @Column
    private String name;

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String address;

    @Column
    private int stars;

    @Column
    private String description;

    @Column
    private BigDecimal pricePerNight;

    @Column
    private HotelRoomEnum roomType;

    @Column
    private BigDecimal priceBreakfast;

    @Column
    private BigDecimal priceDinner;

    @Column
    private BigDecimal allInclusive;

    @ManyToOne
    private BoughtOffersEntity cart;

    public HotelEntity() {
    }

    public HotelEntity(String name, String country,
                       String city, String address,
                       int stars, String description,
                       BigDecimal pricePerNight,
                       HotelRoomEnum roomType,
                       BigDecimal priceBreakfast,
                       BigDecimal priceDinner,
                       BigDecimal allInclusive,
                       BoughtOffersEntity cart) {
        this.name = name;
        this.country = country;
        this.city = city;
        this.address = address;
        this.stars = stars;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.roomType = roomType;
        this.priceBreakfast = priceBreakfast;
        this.priceDinner = priceDinner;
        this.allInclusive = allInclusive;
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public HotelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public HotelEntity setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCity() {
        return city;
    }

    public HotelEntity setCity(String city) {
        this.city = city;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public HotelEntity setAddress(String address) {
        this.address = address;
        return this;
    }

    public int getStars() {
        return stars;
    }

    public HotelEntity setStars(int stars) {
        this.stars = stars;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public HotelEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public HotelEntity setPricePerNight(BigDecimal pricePerNight) {
        this.pricePerNight = pricePerNight;
        return this;
    }

    public HotelRoomEnum getRoomType() {
        return roomType;
    }

    public HotelEntity setRoomType(HotelRoomEnum roomType) {
        this.roomType = roomType;
        return this;
    }

    public BigDecimal getPriceBreakfast() {
        return priceBreakfast;
    }

    public HotelEntity setPriceBreakfast(BigDecimal priceBreakfast) {
        this.priceBreakfast = priceBreakfast;
        return this;
    }

    public BigDecimal getPriceDinner() {
        return priceDinner;
    }

    public HotelEntity setPriceDinner(BigDecimal priceDinner) {
        this.priceDinner = priceDinner;
        return this;
    }

    public BigDecimal getAllInclusive() {
        return allInclusive;
    }

    public HotelEntity setAllInclusive(BigDecimal allInclusive) {
        this.allInclusive = allInclusive;
        return this;
    }

    public BoughtOffersEntity getCart() {
        return cart;
    }

    public HotelEntity setCart(BoughtOffersEntity cart) {
        this.cart = cart;
        return this;
    }
}
