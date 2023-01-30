package com.example.mobilelele.repository;

import com.example.mobilelele.entity.Model;
import com.example.mobilelele.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, String> {
}

