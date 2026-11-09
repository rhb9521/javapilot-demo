package com.javapilot.demo.controller;

import com.javapilot.demo.model.CreateOrderRequest;
import com.javapilot.demo.model.Order;
import com.javapilot.demo.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order create(@Valid @RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @GetMapping("/{id}/description")
    public String describeOrder(@PathVariable Long id) {
        return orderService.describeOrder(id);
    }
}
