package com.example.paymentgateway.payment.Service;

public class PaymentResponse {
    public String response;
    public Integer balance;

    public PaymentResponse(String response, Integer balance) {
        this.response=response;
        this.balance=balance;
    }
}
