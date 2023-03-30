package com.example.coffeeshop.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {
    @Column
    private String name;

    @Column
    private BigDecimal price;

    @Column
    private LocalDateTime neededBefore;

    @ManyToOne
    private Category category;

    @Column
    private String description;

    @ManyToOne
    private User employee;
}
//•	Has an Id – UUID-string or Long
//•	Has a Name
//o	The length of the name must be between 3 and 20 characters (both numbers are INCLUSIVE).
//•	Has a Price
//o	The price must be a positive number
//•	Has an Order time
//o	The date and time that cannot be in the future
//•	Has a Category
//o	Has ONLY ONE category
//o	This is the relation with categories.
//•	Has a Description
//o	The length of the description must be at least 5 (INCLUSIVE) characters
//o	The description is a long text field.
//•	Has a Employee (user)
//o	A user that adds this order to the Coffee Shop application