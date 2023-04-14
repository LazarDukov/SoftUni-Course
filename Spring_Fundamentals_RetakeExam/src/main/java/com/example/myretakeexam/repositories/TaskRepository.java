package com.example.myretakeexam.repositories;

import com.example.myretakeexam.models.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUserId(long loggedUserId);

    List<Task> findByUserIdNot(long loggedUserId);

}
