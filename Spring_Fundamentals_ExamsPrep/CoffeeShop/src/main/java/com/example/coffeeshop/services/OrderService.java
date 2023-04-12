package com.example.coffeeshop.services;

import com.example.coffeeshop.models.dtos.AddOfferDTO;
import com.example.coffeeshop.models.dtos.EmployeeDTO;
import com.example.coffeeshop.models.dtos.OrderDTO;
import com.example.coffeeshop.models.entities.Category;
import com.example.coffeeshop.models.entities.Order;
import com.example.coffeeshop.models.entities.User;
import com.example.coffeeshop.models.enums.CategoryType;
import com.example.coffeeshop.repositories.CategoryRepository;
import com.example.coffeeshop.repositories.OrderRepository;
import com.example.coffeeshop.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;


    private final LoggedUser loggedUser;

    private final ModelMapper modelMapper;

    @Autowired

    public OrderService(OrderRepository orderRepository, UserRepository userRepository, CategoryRepository categoryRepository, LoggedUser loggedUser, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.loggedUser = loggedUser;
        this.modelMapper = modelMapper;
    }

    public boolean addOffer(AddOfferDTO addOfferDTO) {
        Order order = modelMapper.map(addOfferDTO, Order.class);

        order.setEmployee(this.userRepository.findByUsername(loggedUser.getUsername()).get());
        order.setCategory(this.categoryRepository.findByName(addOfferDTO.getCategory()));
        this.orderRepository.save(order);
        return true;



        /*  Optional<User> employee = this.userRepository.findById(this.loggedUser.getId());
        CategoryType categoryType = CategoryType.valueOf(addOfferDTO.getCategory());
        Category category = this.categoryRepository.findByName(categoryType);
        Order order = new Order();
        order.setName(addOfferDTO.getName());
        order.setPrice(addOfferDTO.getPrice());
        order.setNeededBefore(addOfferDTO.getNeededBefore());
        order.setCategory(category);
        order.setDescription(addOfferDTO.getDescription());


        this.orderRepository.save(order);*/
    }

    public List<OrderDTO> getAllOrdersByPrice() {
        return this.orderRepository.findAllByOrderByPriceDesc().stream().map(OrderDTO::new).collect(toList());

    }

    public List<EmployeeDTO> employeeWithOrders() {
        return this.userRepository.findCountByOrder().stream().map(user -> {
            EmployeeDTO employeeDTO = modelMapper.map(user, EmployeeDTO.class);
            employeeDTO.setCountOrders(user.getOrders().size());
            return employeeDTO;
        }).toList();
    }

    public void removeOrderById(Long id) {
        this.orderRepository.deleteById(id);
    }
}
