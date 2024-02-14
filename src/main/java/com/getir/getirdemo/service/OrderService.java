package com.getir.getirdemo.service;


import com.getir.getirdemo.model.Order;
import com.getir.getirdemo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public List<Order> getALlOrders(){
        return orderRepository.findAll();
    }
}
