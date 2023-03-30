package com.example.shoppinglist.services;

import com.example.shoppinglist.models.dtos.ProductByCategoryDTO;
import com.example.shoppinglist.models.dtos.ProductDTO;
import com.example.shoppinglist.models.entities.Category;
import com.example.shoppinglist.models.entities.Product;
import com.example.shoppinglist.models.enums.CategoryType;
import com.example.shoppinglist.repositories.CategoryRepository;
import com.example.shoppinglist.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HomeService {
    private final ProductRepository productRepository;
    private final ProductService productService;

    private final CategoryRepository categoryRepository;

    @Autowired
    public HomeService(ProductRepository productRepository, ProductService productService, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    public Set<ProductDTO> productsByCategory(Category category) {
        return this.productService.findByCategory(category);
    }

    public ProductByCategoryDTO getAllProducts() {
        ProductByCategoryDTO allProducts = new ProductByCategoryDTO();
        allProducts.setFoodProducts(this.productsByCategory(categoryRepository.findByType(CategoryType.FOOD)));
        allProducts.setDrinkProducts(this.productsByCategory(categoryRepository.findByType(CategoryType.DRINK)));
        allProducts.setHouseholdsProducts(this.productsByCategory(categoryRepository.findByType(CategoryType.HOUSEHOLD)));
        allProducts.setOtherProducts(this.productsByCategory(categoryRepository.findByType(CategoryType.OTHER)));
        return allProducts;
    }


}
