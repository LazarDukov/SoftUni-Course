package com.example.shoppinglist.repositories;

import com.example.shoppinglist.models.entities.Category;
import com.example.shoppinglist.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Set<Product> findByCategory(Category category);
}
