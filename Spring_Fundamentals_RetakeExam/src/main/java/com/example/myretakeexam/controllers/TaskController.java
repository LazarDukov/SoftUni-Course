package com.example.myretakeexam.controllers;

import com.example.myretakeexam.models.dtos.AddTaskDTO;
import com.example.myretakeexam.repositories.TaskRepository;
import com.example.myretakeexam.services.TaskService;
import com.example.myretakeexam.session.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TaskController {
    private final LoggedUser loggedUser;

    private final TaskService taskService;

    private final TaskRepository taskRepository;

    public TaskController(LoggedUser loggedUser, TaskService taskService, TaskRepository taskRepository) {
        this.loggedUser = loggedUser;
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @ModelAttribute("addTaskDTO")
    private AddTaskDTO addTaskDTO() {
        return new AddTaskDTO();
    }

    @GetMapping("/task/add")
    private String getAddTaskPage() {
        if (this.loggedUser.isLoggedIn()) {
            return "task-add";
        }
        return "redirect:/";
    }

    @PostMapping("/task/add")
    private String userAddTask(@Valid AddTaskDTO addTaskDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addTaskDTO", addTaskDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addTaskDTO", bindingResult);
            return "redirect:/task/add";
        }
        this.taskService.addTask(addTaskDTO);
        return "redirect:/home";
    }
    @GetMapping("/task/take-task/{id}")
    private String takeTask(@PathVariable long id) {
        taskService.takeTask(id, loggedUser.getId());
        return "redirect:/home";
    }

    @GetMapping("/task/return-task/{id}")
    private String returnTask(@PathVariable long id) {
        taskService.returnTask(id, loggedUser.getId());
        return "redirect:/home";
    }



    @GetMapping("/task/remove/{id}")
    private String doneAndRemoveTask(@PathVariable long id) {
        this.taskService.completeTaskById(id);
        return "redirect:/home";
    }


}
