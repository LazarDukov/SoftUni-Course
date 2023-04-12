package com.example.coffeeshop.services;

import com.example.coffeeshop.models.dtos.OrderDTO;
import com.example.coffeeshop.models.entities.Order;
import com.example.coffeeshop.repositories.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HomeService {
    private final OrderRepository orderRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public HomeService(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    public List<OrderDTO> getAllOrders() {
        return this.orderRepository.findAllByOrderByPriceDesc().stream()
                .map(o -> modelMapper.map(o, OrderDTO.class))
                .collect(Collectors.toList());
    }



}
