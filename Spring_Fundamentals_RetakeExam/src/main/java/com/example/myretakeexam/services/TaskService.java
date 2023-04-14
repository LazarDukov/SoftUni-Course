package com.example.myretakeexam.services;

import com.example.myretakeexam.models.dtos.AddTaskDTO;
import com.example.myretakeexam.models.dtos.TaskDTO;
import com.example.myretakeexam.models.entities.Priority;
import com.example.myretakeexam.models.entities.Task;
import com.example.myretakeexam.models.entities.User;
import com.example.myretakeexam.models.enums.PriorityName;
import com.example.myretakeexam.repositories.PriorityRepository;
import com.example.myretakeexam.repositories.TaskRepository;
import com.example.myretakeexam.repositories.UserRepository;
import com.example.myretakeexam.session.LoggedUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {
    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    private final PriorityRepository priorityRepository;
    private final TaskRepository taskRepository;

    public TaskService(UserRepository userRepository, LoggedUser loggedUser, PriorityRepository priorityRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;

        this.priorityRepository = priorityRepository;
        this.taskRepository = taskRepository;
    }

    public boolean addTask(AddTaskDTO addTaskDTO) {
        Optional<User> logUser = this.userRepository.findById(this.loggedUser.getId());
        if (logUser.isEmpty()) {
            return false;
        }
        PriorityName priorityName = PriorityName.valueOf(addTaskDTO.getPriority().toUpperCase());
        Priority priority = this.priorityRepository.findByName(priorityName);

        Task task = new Task();
        task.setDescription(addTaskDTO.getDescription());
        task.setDueDate(addTaskDTO.getDueDate());
        task.setPriority(priority);
        task.setUser(logUser.get());
        this.taskRepository.save(task);
        return true;
    }

    public List<TaskDTO> getUserTasks(long loggedUserId) {
        return this.taskRepository.findByUserId(loggedUserId).stream().map(TaskDTO::new).collect(Collectors.toList());

    }

    public List<TaskDTO> getNotUserTasks(long loggedUserId) {
        return this.taskRepository.findByUserIdNot(loggedUserId).stream().map(TaskDTO::new).collect(Collectors.toList());
    }

    public void takeTaskWithId(long taskId, long userId) {

    }

    public void takeTask(long taskId, long userId) {
        Task task = taskRepository.findById(taskId).orElse(null); // намираме задачата по id
        User user = userRepository.findById(userId).orElse(null); // намираме логнатия юзър
        task.setUser(user);
        this.taskRepository.findByUserId(taskId).add(task);
        this.taskRepository.findByUserIdNot(taskId).remove(task);
        taskRepository.save(task);
    }

    public void returnTask(long taskId, long userId) {
        Task task = taskRepository.findById(taskId).orElse(null); // намираме задачата по id
        User user = userRepository.findById(userId).orElse(null); // намираме логнатия юзър

        this.taskRepository.findByUserIdNot(taskId).add(task);
        this.taskRepository.findByUserId(taskId).remove(task);
        task.setUser(null);
        this.taskRepository.save(task);
    }


    public void completeTaskById(long id) {
        this.taskRepository.deleteById(id);
    }
}
