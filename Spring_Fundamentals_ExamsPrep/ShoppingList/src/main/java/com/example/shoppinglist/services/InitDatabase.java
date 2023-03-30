package com.example.shoppinglist.services;

import com.example.shoppinglist.models.entities.Category;
import com.example.shoppinglist.models.enums.CategoryType;
import com.example.shoppinglist.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InitDatabase implements CommandLineRunner {
    private final CategoryRepository categoryRepository;

    @Autowired
    public InitDatabase(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.categoryRepository.count() == 0) {
            List<Category> categoryList = Arrays.stream(CategoryType.values()).map(Category::new).collect(Collectors.toList());
            this.categoryRepository.saveAll(categoryList);

        }
    }


}
