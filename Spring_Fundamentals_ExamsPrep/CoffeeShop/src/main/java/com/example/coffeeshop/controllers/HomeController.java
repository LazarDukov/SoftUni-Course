package com.example.coffeeshop.controllers;

import com.example.coffeeshop.models.dtos.EmployeeDTO;
import com.example.coffeeshop.models.dtos.OrderDTO;
import com.example.coffeeshop.services.AuthService;
import com.example.coffeeshop.services.HomeService;
import com.example.coffeeshop.services.LoggedUser;
import com.example.coffeeshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {
    private final LoggedUser loggedUser;
    private final AuthService authService;

    private final HomeService homeService;

    private final OrderService orderService;

    @Autowired
    public HomeController(LoggedUser loggedUser, AuthService authService, HomeService homeService, OrderService orderService) {
        this.loggedUser = loggedUser;
        this.authService = authService;
        this.homeService = homeService;
        this.orderService = orderService;
    }

    @GetMapping("/index")
    private String index() {
        if (this.authService.isUserLogged()) {
            return "redirect:/home";
        }
        return "index";
    }

    @GetMapping("/home")
    private String home(Model model) {
        if (!this.authService.isUserLogged()) {
            return "redirect:/";
        }
        List<OrderDTO> ordersPriceInDescOrder = this.orderService.getAllOrdersByPrice();
        int sumNeededTime = ordersPriceInDescOrder.stream().mapToInt(OrderDTO::getNeededTime).sum();

        List<EmployeeDTO> getEmployeeWithOrders = this.orderService.employeeWithOrders();
        model.addAttribute("orders", this.homeService.getAllOrders());
        model.addAttribute("getNeededTimeForAll", sumNeededTime);
        model.addAttribute("getEmployeeWithOrders", getEmployeeWithOrders);
        return "home";
    }

    @GetMapping("/logout")
    private String logout() {
        this.loggedUser.logout();
        return "index";
    }
    @GetMapping("/ready/{id}")
    String buyProduct(@PathVariable("id") Long id){
        if (!this.authService.isUserLogged()) {
            return "redirect:/";
        }
        this.orderService.removeOrderById(id);
        return "redirect:/home";
    }

}
