package com.example.mobilelele.repository;

import com.example.mobilelele.entity.Brand;
import com.example.mobilelele.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, String> {
}


