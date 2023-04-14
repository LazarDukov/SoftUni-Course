package com.example.myretakeexam.models.dtos;

import com.example.myretakeexam.models.entities.Priority;
import com.example.myretakeexam.models.entities.Task;
import com.example.myretakeexam.models.entities.User;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private long id;
    private String description;

    private int count;
    private LocalDate dueDate;
    private Set<Task> userTasks;
    private Priority priority;

    public TaskDTO(Task task) {
        this.id = task.getId();
        this.description = task.getDescription();
        this.count = task.getUser().getTasks().size();
        this.dueDate = task.getDueDate();
        this.userTasks = task.getUser().getTasks();
        this.priority = task.getPriority();
    }
}
