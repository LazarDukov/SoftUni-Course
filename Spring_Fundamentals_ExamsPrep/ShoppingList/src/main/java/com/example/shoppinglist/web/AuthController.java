package com.example.shoppinglist.web;

import com.example.shoppinglist.models.dtos.UserLoginDTO;
import com.example.shoppinglist.models.dtos.UserRegistrationDTO;
import com.example.shoppinglist.services.AuthService;
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

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        if (this.authService.isUserLogged()) {
            return "redirect:/";
        }
        this.authService.logout();
        return "redirect:/";
    }

    @ModelAttribute("userRegistrationDTO")
    public UserRegistrationDTO createUserRegistrationDTO() {
        return new UserRegistrationDTO();
    }

    @ModelAttribute("userLoginDTO")
    public UserLoginDTO createUserLoginDTO() {
        return new UserLoginDTO();
    }

    @PostMapping("/register")
    public String register(@Valid UserRegistrationDTO registrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !this.authService.register(registrationDTO)) {
            redirectAttributes.addFlashAttribute("userRegistrationDTO", registrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegistrationDTO",
                    bindingResult);
            return "redirect:/register";
        }
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO loginDTO,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO",
                    bindingResult);
            return "redirect:/login";
        }
        if (!this.authService.login(loginDTO)) {
            redirectAttributes.addFlashAttribute("userLoginDTO", loginDTO);
            redirectAttributes.addFlashAttribute("BadCredentials", true);
            return "redirect:/login";
        }
        return "redirect:/home";
    }


}
