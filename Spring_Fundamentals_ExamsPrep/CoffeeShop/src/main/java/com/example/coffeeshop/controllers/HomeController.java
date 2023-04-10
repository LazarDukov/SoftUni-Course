package com.example.coffeeshop.controllers;

import com.example.coffeeshop.models.dtos.AddOfferDTO;
import com.example.coffeeshop.services.AuthService;
import com.example.coffeeshop.services.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
    private final LoggedUser loggedUser;
    private final AuthService authService;

    @Autowired
    public HomeController(LoggedUser loggedUser, AuthService authService) {
        this.loggedUser = loggedUser;
        this.authService = authService;
    }

    @GetMapping("/index")
    private String index() {
        if (this.authService.isUserLogged()) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    private String home(Model model) {
        if (!this.authService.isUserLogged()) {
            return "redirect:/";
        }
        model.addAttribute("")
        return "home";
    }

    @GetMapping("/logout")
    private String logout() {
        this.loggedUser.logout();
        return "index";
    }




}
