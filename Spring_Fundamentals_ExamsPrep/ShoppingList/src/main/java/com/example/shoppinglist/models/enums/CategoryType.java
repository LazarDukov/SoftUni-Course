package com.example.shoppinglist.models.enums;


public enum CategoryType {
    FOOD("Food"),
    DRINK("Drink"),
    HOUSEHOLD("Household"),
    OTHER("Other");

    private final String type;

    CategoryType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
