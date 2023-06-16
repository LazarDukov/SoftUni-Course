package com.example.travelseeker.model.entities;

import com.example.travelseeker.model.enums.CategoryEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{
    @Column
    private CategoryEnum category;

    @Column
    private String description;

    public CategoryEntity() {
    }

    public CategoryEntity(CategoryEnum category, String description) {
        this.category = category;
        this.description = description;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public CategoryEntity setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
