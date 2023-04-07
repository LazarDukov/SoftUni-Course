package com.example.coffeeshop.services;

import com.example.coffeeshop.models.entities.Category;
import com.example.coffeeshop.models.enums.CategoryType;
import com.example.coffeeshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DbInitService implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    @Autowired
    public DbInitService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.categoryRepository.count() == 0) {
            List<CategoryType> types = List.of(CategoryType.values());

            for (CategoryType type :
                    types) {
                int value = type.getNeededTime();
                Category category = new Category();
                category.setName(type);
                category.setNeededTime(type.getNeededTime());
                this.categoryRepository.save(category);
            }

        }
    }
}
