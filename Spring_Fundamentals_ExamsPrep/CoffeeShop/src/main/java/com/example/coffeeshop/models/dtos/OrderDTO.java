package com.example.coffeeshop.models.dtos;

import com.example.coffeeshop.models.entities.Category;
import com.example.coffeeshop.models.entities.Order;
import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private String category;
    private int neededTime;


    public OrderDTO(Order order) {
        this.id = order.getId();
        this.name = order.getName();
        this.price = order.getPrice();
        this.category = order.getCategory().getName().toString();
        this.neededTime = order.getCategory().getNeededTime();
    }



}
