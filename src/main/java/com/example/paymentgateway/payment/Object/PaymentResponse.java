package com.example.paymentgateway.payment.Object;

public class PaymentResponse {
    public String response;
    public String balance;
    public Boolean status;

    public PaymentResponse(String response, String balance,Boolean status ) {
        this.response=response;
        this.balance=balance;
        this.status=status;
    }
}
