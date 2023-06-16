package com.example.travelseeker.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name = "cart")
public class BoughtOffersEntity extends BaseEntity {
    @ManyToOne
    private UserEntity user;

    @OneToMany
    private List<HotelEntity> hotelsBought;

    @OneToMany
    private List<CarRentEntity> carsRented;

    public BoughtOffersEntity() {
    }

    public BoughtOffersEntity(UserEntity user, List<HotelEntity> hotelsBought, List<CarRentEntity> carsRented) {
        this.user = user;
        this.hotelsBought = hotelsBought;
        this.carsRented = carsRented;
    }

    public UserEntity getUser() {
        return user;
    }

    public BoughtOffersEntity setUser(UserEntity user) {
        this.user = user;
        return this;
    }

    public List<HotelEntity> getHotelsBought() {
        return hotelsBought;
    }

    public BoughtOffersEntity setHotelsBought(List<HotelEntity> hotelsBought) {
        this.hotelsBought = hotelsBought;
        return this;
    }

    public List<CarRentEntity> getCarsRented() {
        return carsRented;
    }

    public BoughtOffersEntity setCarsRented(List<CarRentEntity> carsRented) {
        this.carsRented = carsRented;
        return this;
    }
}
