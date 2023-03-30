package com.example.shoppinglist.web;

import com.example.shoppinglist.models.dtos.ProductByCategoryDTO;
import com.example.shoppinglist.services.AuthService;
import com.example.shoppinglist.services.HomeService;
import com.example.shoppinglist.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    private final AuthService authService;
    private final HomeService homeService;

    private final ProductService productService;

    @Autowired
    public HomeController(AuthService authService, HomeService homeService, ProductService productService) {
        this.authService = authService;
        this.homeService = homeService;
        this.productService = productService;
    }

    @ModelAttribute
    public ProductByCategoryDTO allProducts() {
        return new ProductByCategoryDTO();
    }

    @GetMapping("/index")
    public String index() {
        if (this.authService.isUserLogged()) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (!this.authService.isUserLogged()) {
            return "redirect:/";
        }
        model.addAttribute("allProducts", this.homeService.getAllProducts());
        model.addAttribute("totalPrice", this.productService.getTotalPrice());
        return "home";

    }

    @GetMapping("/buy/{id}")
    public String buyProduct(@PathVariable("id") Long id) {
        if (!this.authService.isUserLogged()) {
            return "redirect:/";
        }
        this.productService.removeProductById(id);
        return "redirect:/home";
    }

    @GetMapping("/buyAll")
    public String buyAllProducts() {
        if (!this.authService.isUserLogged()) {
            return "redirect:/";
        }
        this.productService.removeAll();
        return "redirect:/home";
    }
}
