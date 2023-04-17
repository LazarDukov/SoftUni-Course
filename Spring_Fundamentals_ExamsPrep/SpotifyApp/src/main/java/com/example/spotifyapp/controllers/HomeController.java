package com.example.spotifyapp.controllers;

import com.example.spotifyapp.session.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final LoggedUser loggedUser;

    @Autowired
    public HomeController(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public String getIndexPage() {
        if (loggedUser.isUserLoggedIn()) {
            return "redirect:/home";
        }
        return "index";
    }
}
