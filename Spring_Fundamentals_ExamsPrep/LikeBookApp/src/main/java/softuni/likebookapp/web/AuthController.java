package softuni.likebookapp.web;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.likebookapp.models.dtos.LoginDTO;
import softuni.likebookapp.models.dtos.RegistrationDTO;
import softuni.likebookapp.models.entities.User;
import softuni.likebookapp.repositories.UserRepository;
import softuni.likebookapp.services.AuthService;
import softuni.likebookapp.session.LoggedUser;

@Controller
public class AuthController {
    private final LoggedUser loggedUser;

    private final AuthService authService;

    private final UserRepository userRepository;

    public AuthController(LoggedUser loggedUser, AuthService authService, UserRepository userRepository) {
        this.loggedUser = loggedUser;
        this.authService = authService;
        this.userRepository = userRepository;
    }

    @GetMapping("/index")
    private String indexPage() {
        return "index";
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
