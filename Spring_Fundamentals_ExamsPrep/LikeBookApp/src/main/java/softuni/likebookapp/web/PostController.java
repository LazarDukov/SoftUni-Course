package softuni.likebookapp.web;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.likebookapp.models.dtos.AddPostDTO;
import softuni.likebookapp.services.PostService;
import softuni.likebookapp.session.LoggedUser;

@Controller
public class PostController {
    private final LoggedUser loggedUser;

    private final PostService postService;

    @Autowired
    public PostController(LoggedUser loggedUser, PostService postService) {
        this.loggedUser = loggedUser;
        this.postService = postService;
    }

    @ModelAttribute("addPostDTO")
    private AddPostDTO addPostDTO() {
        return new AddPostDTO();
    }

    @GetMapping("/post/add")
    private String getAddPostPage() {
        if (!loggedUser.isLoggedIn()) {
            return "redirect:/";
        }
        return "post-add";
    }

    @PostMapping("/post/add")
    private String userAddPost(@Valid AddPostDTO addPostDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addPostDTO", addPostDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addPostDTO", bindingResult);
            return "redirect:/post/add";
        }
        this.postService.addPost(addPostDTO);
        return "redirect:/home";
    }


}
