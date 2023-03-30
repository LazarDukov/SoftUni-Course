package com.example.shoppinglist.web;

import com.example.shoppinglist.models.dtos.AddProductDTO;
import com.example.shoppinglist.models.dtos.ProductDTO;
import com.example.shoppinglist.services.AuthService;
import com.example.shoppinglist.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    private final AuthService authService;
    private final ProductService productService;


    public ProductController(AuthService authService, ProductService productService) {
        this.authService = authService;
        this.productService = productService;
    }


    @ModelAttribute("ProductDTO")
    public ProductDTO createProductDTO() {
        return new ProductDTO();
    }

    @ModelAttribute("addProductDTO")
    public AddProductDTO createAddProductDTO() {
        return new AddProductDTO();
    }

    @GetMapping("/product/add")
    public String getAddProduct() {

        return "product-add";
    }

    @PostMapping("/product/add")
    public String addProduct(@Valid AddProductDTO addProductDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !this.productService.addProduct(addProductDTO)) {
            redirectAttributes.addFlashAttribute("addProductDTO", addProductDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addProductDTO", bindingResult);
            return "redirect:/product/add";
        }
        return "redirect:/home";
    }
}
