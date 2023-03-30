package com.example.shoppinglist.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column
    private Double price;

    @Column
    private LocalDateTime neededBefore;

    @ManyToOne
    private Category category;
}
