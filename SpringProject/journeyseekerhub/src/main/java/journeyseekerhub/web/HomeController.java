package journeyseekerhub.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String getIndex() {
        return "index1";
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}
