package com.javapilot.demo.model;

import java.math.BigDecimal;
import java.time.Instant;

public class Order {
    private Long id;
    private String userId;
    private BigDecimal originalAmount;
    private BigDecimal payableAmount;
    private Instant createdAt;

    public Order() {
    }

    public Order(Long id, String userId, BigDecimal originalAmount,
                 BigDecimal payableAmount, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.originalAmount = originalAmount;
        this.payableAmount = payableAmount;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public BigDecimal getOriginalAmount() { return originalAmount; }
    public void setOriginalAmount(BigDecimal originalAmount) { this.originalAmount = originalAmount; }
    public BigDecimal getPayableAmount() { return payableAmount; }
    public void setPayableAmount(BigDecimal payableAmount) { this.payableAmount = payableAmount; }
    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
