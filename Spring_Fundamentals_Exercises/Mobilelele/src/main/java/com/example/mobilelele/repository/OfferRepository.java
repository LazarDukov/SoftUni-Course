package com.example.mobilelele.repository;

import com.example.mobilelele.entity.Model;
import com.example.mobilelele.entity.Offer;
import com.example.mobilelele.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, String> {
}

