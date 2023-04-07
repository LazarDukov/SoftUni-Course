package com.example.coffeeshop.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum CategoryType {

    COFFEE(2),
    CAKE(10),
    DRINK(1),
    OTHER(5);

    private int neededTime;
    }
