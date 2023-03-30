package com.example.shoppinglist.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductByCategoryDTO {
    private Set<ProductDTO> foodProducts;
    private Set<ProductDTO> drinkProducts;
    private Set<ProductDTO> householdsProducts;
    private Set<ProductDTO> otherProducts;



}
