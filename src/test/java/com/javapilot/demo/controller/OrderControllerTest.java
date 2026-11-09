package com.javapilot.demo.controller;

import com.javapilot.demo.model.CreateOrderRequest;
import com.javapilot.demo.model.Order;
import com.javapilot.demo.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.Instant;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    void createOrderReturnsCreatedOrderPayload() throws Exception {
        given(orderService.createOrder(any(CreateOrderRequest.class)))
                .willReturn(new Order(1001L, "user-100", new BigDecimal("120.00"),
                        new BigDecimal("96.00"), Instant.parse("2026-01-01T00:00:00Z")));

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"userId":"user-100","amount":120.00,"vip":true}
                                """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1001))
                .andExpect(jsonPath("$.payableAmount").value(96.00));
    }
}
