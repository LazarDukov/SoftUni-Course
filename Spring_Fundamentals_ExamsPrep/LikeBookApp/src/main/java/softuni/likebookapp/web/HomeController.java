package softuni.likebookapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import softuni.likebookapp.models.dtos.PostDTO;
import softuni.likebookapp.services.AuthService;
import softuni.likebookapp.services.PostService;
import softuni.likebookapp.session.LoggedUser;

import java.util.List;

@Controller
public class HomeController {
    private final LoggedUser loggedUser;

    private final AuthService authService;

    private final PostService postService;

    @Autowired
    public HomeController(LoggedUser loggedUser, AuthService authService, PostService postService) {
        this.loggedUser = loggedUser;
        this.authService = authService;
        this.postService = postService;
    }

    @GetMapping("/home")
    public String homePage(Model model) {
        if (!this.loggedUser.isLoggedIn()) {
            return "redirect:/";
        }
        Long loggedUserId = this.loggedUser.getId();
        List<PostDTO> userPosts = this.postService.getUserPosts(loggedUserId);
        model.addAttribute("userPosts", userPosts);
        List<PostDTO> notUserPosts = this.postService.getNotUserPosts(loggedUserId);
        model.addAttribute("notUserPosts", notUserPosts);


        return "home";
    }


}
