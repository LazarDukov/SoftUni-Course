package com.example.coffeeshop.models.entities;

import com.example.coffeeshop.models.enums.CategoryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {
    @Enumerated(EnumType.STRING)
    private CategoryType name;

    @Column
    private int neededTime;


}

//•	Has an Id – UUID-string or Long
//•	Has a Name
//o	An option between (Coffee, Cake, Drink, Other)
//•	Has a Needed Time (just an integer)
//o	The approximate time in minutes needed for the preparation
//of a product of the specified category.
//	The needed time for a Drink is 1 min.
//	The needed time for Coffee is 2 min.
//	The needed time for an Other is 5 min.
//	The needed time for a Cake is 10 min.
