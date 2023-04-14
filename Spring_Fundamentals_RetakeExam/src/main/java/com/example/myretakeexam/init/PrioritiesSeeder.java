package com.example.myretakeexam.init;

import com.example.myretakeexam.models.entities.Priority;
import com.example.myretakeexam.models.enums.PriorityName;
import com.example.myretakeexam.repositories.PriorityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PrioritiesSeeder implements CommandLineRunner {
    private final PriorityRepository priorityRepository;

    public PrioritiesSeeder(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.priorityRepository.count() == 0) {
            List<Priority> priorities = Arrays.stream(PriorityName.values())
                    .map(Priority::new).toList();
            this.priorityRepository.saveAll(priorities);
        }
    }
}
