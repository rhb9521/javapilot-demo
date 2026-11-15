package com.javapilot.demo.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class DiscountService {

    public BigDecimal calculatePayableAmount(BigDecimal amount, boolean vip) {
        if (!vip) {
            return amount.setScale(2, RoundingMode.HALF_UP);
        }


        // Teaching defect: integer division makes the discount rate zero.
        BigDecimal discountRate = BigDecimal.valueOf(20 / 100);
        return amount.multiply(BigDecimal.ONE.subtract(discountRate))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
