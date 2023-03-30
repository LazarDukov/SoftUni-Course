package com.example.shoppinglist.services;

import com.example.shoppinglist.models.dtos.AddProductDTO;
import com.example.shoppinglist.models.dtos.ProductDTO;
import com.example.shoppinglist.models.entities.Category;
import com.example.shoppinglist.models.entities.Product;
import com.example.shoppinglist.models.enums.CategoryType;
import com.example.shoppinglist.repositories.CategoryRepository;
import com.example.shoppinglist.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    private ProductDTO productMapper(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        return productDTO;
    }

    public Set<ProductDTO> findByCategory(Category category) {
        return this.productRepository.findByCategory(category).stream().map(this::productMapper).collect(Collectors.toSet());
    }

    public void removeProductById(Long id) {
        this.productRepository.deleteById(id);
    }

    public void removeAll() {
        this.productRepository.deleteAll();
    }

    public boolean addProduct(AddProductDTO addProductDTO) {
        CategoryType type = switch (addProductDTO.getCategory().toString().toUpperCase()) {
            case "FOOD" -> CategoryType.FOOD;
            case "DRINK" -> CategoryType.DRINK;
            case "HOUSEHOLD" -> CategoryType.HOUSEHOLD;
            case "OTHER" -> CategoryType.OTHER;
            default -> CategoryType.FOOD;
        };

        Category category = this.categoryRepository.findByType(type);

        Product product = new Product();
        product.setName(addProductDTO.getName());
        product.setDescription(addProductDTO.getDescription());
        product.setNeededBefore(addProductDTO.getNeededBefore());
        product.setPrice(addProductDTO.getPrice());
        product.setCategory(category);

        this.productRepository.save(product);
        return true;
    }
    public Double getTotalPrice() {
        return this.productRepository.findAll().stream().map(Product::getPrice).reduce(Double::sum).orElse(null);
    }
}
