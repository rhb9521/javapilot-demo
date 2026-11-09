package com.javapilot.demo.service;

import com.javapilot.demo.model.CreateOrderRequest;
import com.javapilot.demo.model.Order;
import com.javapilot.demo.repository.InMemoryOrderRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class OrderService {

    private final InMemoryOrderRepository repository;
    private final DiscountService discountService;

    public OrderService(InMemoryOrderRepository repository, DiscountService discountService) {
        this.repository = repository;
        this.discountService = discountService;
    }

    public Order createOrder(CreateOrderRequest request) {
        var payable = discountService.calculatePayableAmount(request.getAmount(), request.isVip());
        Order order = new Order(
                null,
                request.getUserId(),
                request.getAmount(),
                payable,
                Instant.now()
        );
        return repository.save(order);
    }

    public Order findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Teaching defect: this caller dereferences the nullable result without checking it.
    public String describeOrder(Long id) {
        Order order = findById(id);
        return "Order " + order.getId() + " belongs to " + order.getUserId();
    }
}
