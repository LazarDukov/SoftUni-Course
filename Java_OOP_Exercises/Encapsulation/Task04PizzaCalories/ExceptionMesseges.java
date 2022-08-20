package pizzaCalories;

public class ExceptionMesseges {
    public static final String INVALID_TYPE_OF_DOUGH = "Invalid type of dough.";
    //•	If dough weight is outside of the range [1..200] throw an exception with the message "Dough weight should be in the range [1..200]."
    public static final String OUT_OF_RANGE = "Dough weight should be in the range [1..200].";
    //•	If topping is not one of the provided types throw an exception with the message "Cannot place {name of invalid argument} on top of your pizza."
    public static final String TOPPING_DIFFERENT_TYPE = "Cannot place %s on top of your pizza.";
    //•	If topping weight is outside of the range [1..50] throw an exception with the message "{Topping type name} weight should be in the range [1..50].".
    public static final String TOPPING_WEIGHT_OUTSIDE_OF_RANGE = "%s weight should be in the range [1..50].";
    //•	If the name of the pizza is empty, only whitespace or longer than 15 symbols throw an exception with the message "Pizza name should be between 1 and 15 symbols.".
    public static final String EMPTY_OR_LONGER_THAN_15_SYMBOLS = "Pizza name should be between 1 and 15 symbols.";
    //•	If a number of toppings are outside of the range [0..10] throw an exception with the message "Number of toppings should be in range [0..10].".
    public static final String TOPPINGS_NUMBER_OUTSIDE_OF_RANGE = "Number of toppings should be in range [0..10].";
}
