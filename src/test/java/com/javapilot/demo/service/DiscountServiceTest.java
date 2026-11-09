package com.javapilot.demo.service;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DiscountServiceTest {

    private final DiscountService discountService = new DiscountService();

    @Test
    void nonVipCustomerPaysOriginalAmount() {
        assertEquals(new BigDecimal("100.00"),
                discountService.calculatePayableAmount(new BigDecimal("100.00"), false));
    }

    @Test
    void vipCustomerShouldReceiveTwentyPercentDiscount() {
        // This test is expected to fail until the teaching defect is fixed.
        assertEquals(new BigDecimal("80.00"),
                discountService.calculatePayableAmount(new BigDecimal("100.00"), true));
    }
}
