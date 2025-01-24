package com.scaler.firstpaymentservice.configs;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RazorpayClientConfig {
    @Value(value = "${razorpay.key.id}")
    private String razorpayKeyId;
    @Value(value = "${razorpay.key.secret}")
    private String razorpaySecret;
    @Bean
    public RazorpayClient createRazorpayClient() throws RazorpayException {
        return new RazorpayClient(razorpayKeyId, razorpaySecret);
    }
}
