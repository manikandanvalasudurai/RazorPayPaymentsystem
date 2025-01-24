package com.scaler.firstpaymentservice.dtos;

public class GeneratePaymentLinkRequestDto {
    private Long orderId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
