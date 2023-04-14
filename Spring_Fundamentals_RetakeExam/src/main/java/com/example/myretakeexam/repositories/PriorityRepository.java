package com.example.myretakeexam.repositories;

import com.example.myretakeexam.models.entities.Priority;
import com.example.myretakeexam.models.enums.PriorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
    Priority findByName(PriorityName name);
}
