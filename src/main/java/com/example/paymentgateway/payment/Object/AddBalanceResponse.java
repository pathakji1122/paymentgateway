package com.example.paymentgateway.payment.Object;

public class AddBalanceResponse {
    public String response;
    public Boolean status;

    public AddBalanceResponse(String response, Boolean status) {
        this.response = response;
        this.status = status;
    }
}
