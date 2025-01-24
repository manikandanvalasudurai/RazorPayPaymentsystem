package com.scaler.firstpaymentservice.controllers;

import com.razorpay.RazorpayException;
import com.scaler.firstpaymentservice.dtos.GeneratePaymentLinkRequestDto;
import com.scaler.firstpaymentservice.services.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentControllers {
    private PaymentService paymentService;
    public PaymentControllers(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping()
    public String generatePaymentLink(@RequestBody GeneratePaymentLinkRequestDto requestDto) throws RazorpayException {
        return paymentService.generatePaymentLink(requestDto.getOrderId());
    }
    @PostMapping("/webhook")
    public void handleWebhookEvent(@RequestBody Object object){
        System.out.println("webhook Triggered");
    }
}

