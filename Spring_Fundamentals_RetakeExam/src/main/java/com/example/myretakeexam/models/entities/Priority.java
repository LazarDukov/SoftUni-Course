package com.example.myretakeexam.models.entities;

import com.example.myretakeexam.models.enums.PriorityName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "priorities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Priority extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false, unique = true)
    private PriorityName name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "priority", fetch = FetchType.EAGER)
    private Set<Task> tasks;


    public Priority(PriorityName priorityName) {
        this.name = priorityName;
        this.description =
                switch (priorityName.toString()) {
                    case "URGENT" -> "An urgent problem that blocks the system use until the issue is resolved.";
                    case "IMPORTANT" ->
                            "A core functionality that your product is explicitly supposed to perform is compromised.";
                    case "LOW" -> "Should be fixed if time permits but can be postponed.";
                    default -> "Description misses!";
                };
    }
}
