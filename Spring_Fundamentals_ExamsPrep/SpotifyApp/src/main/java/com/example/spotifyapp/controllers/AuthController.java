package com.example.spotifyapp.controllers;

import com.example.spotifyapp.models.dtos.LoginDTO;
import com.example.spotifyapp.models.dtos.RegisterDTO;
import com.example.spotifyapp.repositories.UserRepository;
import com.example.spotifyapp.services.AuthService;
import com.example.spotifyapp.session.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
    private final UserRepository userRepository;

    private final LoggedUser loggedUser;

    private final AuthService authService;

    public AuthController(UserRepository userRepository, LoggedUser loggedUser, AuthService authService) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
        this.authService = authService;
    }

    @ModelAttribute("loginDTO")
    private LoginDTO loginDTO() {
        return new LoginDTO();
    }

    @ModelAttribute("registerDTO")
    private RegisterDTO registerDTO() {
        return new RegisterDTO();
    }

    @GetMapping("/login")
    private String getLoginPage() {
        return "login";
    }

    @GetMapping("/register")
    private String getRegisterPage() {
        return "register";
    }

    @PostMapping("/login")
    private String postLoginPage(@Valid LoginDTO loginDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", bindingResult);
            return "redirect:/login";
        }
        if (!this.authService.checkLoginValidations(loginDTO)) {
            redirectAttributes.addFlashAttribute("loginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);
            return "redirect:/login";
        }

        return "redirect:/home";
    }

    @PostMapping("/register")
    private String postRegisterPage(@Valid RegisterDTO registerDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", bindingResult);
            return "redirect:/register";
        }
        if (!this.authService.checkRegisterValidations(registerDTO)) {
            redirectAttributes.addFlashAttribute("registerDTO", registerDTO);
            redirectAttributes.addFlashAttribute("badCredentials", true);
            return "redirect:/register";
        }
        return "redirect:/login";
    }

}
