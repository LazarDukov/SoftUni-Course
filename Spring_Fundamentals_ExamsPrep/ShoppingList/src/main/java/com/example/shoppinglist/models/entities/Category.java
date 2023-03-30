package com.example.shoppinglist.models.entities;

import com.example.shoppinglist.models.enums.CategoryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CategoryType type;

    @Column(columnDefinition = "TEXT")
    private String typeDescription;

    public Category(CategoryType categoryType) {
        this.type = categoryType;
    }
}
