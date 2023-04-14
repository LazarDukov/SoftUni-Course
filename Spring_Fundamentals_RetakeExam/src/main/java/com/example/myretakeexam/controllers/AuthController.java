package com.example.myretakeexam.controllers;

import com.example.myretakeexam.models.dtos.LoginDTO;
import com.example.myretakeexam.models.dtos.RegistrationDTO;
import com.example.myretakeexam.services.AuthService;
import com.example.myretakeexam.session.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    private final AuthService authService;

    private final LoggedUser loggedUser;


    public AuthController(AuthService authService, LoggedUser loggedUser) {
        this.authService = authService;
        this.loggedUser = loggedUser;
    }


    @GetMapping("/login")
    private String getLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    private String getRegisterPage() {
        return "register";
    }

    @ModelAttribute("loginDTO")
    private LoginDTO createLoginDTO() {
        return new LoginDTO();
    }

    @ModelAttribute("registrationDTO")
    private RegistrationDTO createRegistrationDTO() {
        return new RegistrationDTO();
    }

    @PostMapping("/login")
    private String postLoginPage(@Valid LoginDTO loginDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", bindingResult);
            return "redirect:/login";
        }
        if (!this.authService.userLogin(loginDTO)) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);
            return "redirect:/login";
        }

        return "redirect:/home";


    }

    @PostMapping("/register")
    private String postRegistrationPage(@Valid RegistrationDTO registrationDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registrationDTO", registrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registrationDTO", bindingResult);
            return "redirect:/register";
        }
        this.authService.userRegister(registrationDTO);
        return "redirect:/login";
    }

    @GetMapping("/logout")
    private String logoutPage() {
        this.loggedUser.logout();
        return "redirect:/";
    }
}
