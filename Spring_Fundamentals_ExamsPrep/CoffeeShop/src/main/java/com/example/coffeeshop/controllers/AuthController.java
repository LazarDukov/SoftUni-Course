package com.example.coffeeshop.controllers;

import com.example.coffeeshop.models.dtos.LoginDTO;
import com.example.coffeeshop.models.dtos.RegisterDTO;
import com.example.coffeeshop.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Autowired


    @GetMapping("/login")
    private String getLogin() {
        return "login";
    }

    @GetMapping("/register")
    private String getRegister() {
        return "register";
    }

    @ModelAttribute("loginDTO")
    private LoginDTO loginDTO() {
        return new LoginDTO();
    }

    @ModelAttribute("registerDTO")
    private RegisterDTO registerDTO() {
        return new RegisterDTO();
    }

    @PostMapping("/login")
    private String postLogin(@Valid LoginDTO loginDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", bindingResult);
            return "redirect:/login";
        }
        if (!this.authService.login(loginDTO)) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);
            return "redirect:/login";
        }
        return "home";

    }

    @PostMapping("/register")
    private String postRegister(@Valid RegisterDTO registerDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !this.authService.register(registerDTO)) {
            redirectAttributes.addFlashAttribute
                    ("registerDTO", registerDTO);
            redirectAttributes.addFlashAttribute
                    ("org.springframework.validation.BindingResult.registerDTO", bindingResult);
            return "redirect:/register";
        }
        return "redirect:/login";

    }
}
