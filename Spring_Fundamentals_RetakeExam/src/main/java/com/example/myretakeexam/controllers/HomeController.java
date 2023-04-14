package com.example.myretakeexam.controllers;

import com.example.myretakeexam.models.dtos.TaskDTO;
import com.example.myretakeexam.services.TaskService;
import com.example.myretakeexam.session.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final TaskService taskService;
    private final LoggedUser loggedUser;

    public HomeController(TaskService taskService, LoggedUser loggedUser) {
        this.taskService = taskService;
        this.loggedUser = loggedUser;
    }


    @GetMapping("/home")
    public String homePage(Model model) {
        if (!this.loggedUser.isLoggedIn()) {
            return "redirect:/";
        }
        long loggedUserId = this.loggedUser.getId();
        List<TaskDTO> userTasks = this.taskService.getUserTasks(loggedUserId);
        model.addAttribute("userTasks", userTasks);
        List<TaskDTO> notUserTasks = this.taskService.getNotUserTasks(loggedUserId);
        model.addAttribute("notUserTasks", notUserTasks);


        return "home";
    }


}
