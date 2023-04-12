package com.example.coffeeshop.controllers;

import com.example.coffeeshop.models.dtos.AddOfferDTO;
import com.example.coffeeshop.repositories.OrderRepository;
import com.example.coffeeshop.services.AuthService;
import com.example.coffeeshop.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {

    private final AuthService authService;
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    @Autowired
    public OrderController(AuthService authService, OrderRepository orderRepository, OrderService orderService) {
        this.authService = authService;
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }


    @ModelAttribute("addOfferDTO")
    private AddOfferDTO addOffer() {
        return new AddOfferDTO();
    }

    @GetMapping("/offer/add")
    private String getAddOffer() {
        if (!this.authService.isUserLogged()) {
            return "redirect:/";
        }
        return "order-add";
    }

    @PostMapping("/offer/add")
    private String postAddOffer(@Valid AddOfferDTO addOfferDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addOfferDTO", addOfferDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOfferDTO", bindingResult);
            return "redirect:/offer/add";
        }
        this.orderService.addOffer(addOfferDTO);

        return "redirect:/home";
    }
}
