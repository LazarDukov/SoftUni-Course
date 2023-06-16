package com.example.travelseeker.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "airplane_tickets")
public class AirplaneTicketsEntity extends BaseEntity {
    @Column
    private String companyName;

    @Column
    private LocalDateTime date;

    @Column
    private String fromAirport;

    @Column
    private String toAirport;

    @Column
    private String flyNumber;

    @Column
    private BigDecimal price;

    @Column
    private BigDecimal moreLuggagePrice;

    @ManyToOne
    private BoughtOffersEntity cart;

    public AirplaneTicketsEntity() {
    }

    public AirplaneTicketsEntity(String companyName,
                                 LocalDateTime date,
                                 String fromAirport,
                                 String toAirport,
                                 String flightNumber,
                                 BigDecimal price,
                                 BigDecimal moreLuggagePrice,
                                 BoughtOffersEntity cart) {
        this.companyName = companyName;
        this.date = date;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.flyNumber = flightNumber;
        this.price = price;
        this.moreLuggagePrice = moreLuggagePrice;
        this.cart = cart;
    }

    public String getCompanyName() {
        return companyName;
    }

    public AirplaneTicketsEntity setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public AirplaneTicketsEntity setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public String getFromAirport() {
        return fromAirport;
    }

    public AirplaneTicketsEntity setFromAirport(String fromAirport) {
        this.fromAirport = fromAirport;
        return this;
    }

    public String getToAirport() {
        return toAirport;
    }

    public AirplaneTicketsEntity setToAirport(String toAirport) {
        this.toAirport = toAirport;
        return this;
    }

    public String getFlyNumber() {
        return flyNumber;
    }

    public AirplaneTicketsEntity setFlyNumber(String flyNumber) {
        this.flyNumber = flyNumber;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AirplaneTicketsEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getMoreLuggagePrice() {
        return moreLuggagePrice;
    }

    public AirplaneTicketsEntity setMoreLuggagePrice(BigDecimal moreLuggagePrice) {
        this.moreLuggagePrice = moreLuggagePrice;
        return this;
    }

    public BoughtOffersEntity getCart() {
        return cart;
    }

    public AirplaneTicketsEntity setCart(BoughtOffersEntity cart) {
        this.cart = cart;
        return this;
    }
}
