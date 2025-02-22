package com.scaler.firstpaymentservice.services;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RayzorpayPaymentGateway implements PaymentService{
    private RazorpayClient razorpayClient;
    public RayzorpayPaymentGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }
    @Override
    public String generatePaymentLink(Long orderId) throws RazorpayException {
        // Initialize client

        //Make a call to RazorPay to generate the payment link
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount",200000);  // 10.00
        paymentLinkRequest.put("currency","INR");
     //   paymentLinkRequest.put("accept_partial",true);
     //   paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",System.currentTimeMillis() + 10 * 60 * 1000);
        paymentLinkRequest.put("reference_id",orderId.toString());
        paymentLinkRequest.put("description","Payment of 1000000");
        JSONObject customer = new JSONObject();

        //call the order service to get the details

        customer.put("name","MKV");
        customer.put("contact","+918888888888");
        customer.put("email","Demo@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",true);
        notify.put("email",true);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Jeevan Bima");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://scaler.com/");
        paymentLinkRequest.put("callback_method","get");

        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);

        return payment.get("short_url");
    }
}
