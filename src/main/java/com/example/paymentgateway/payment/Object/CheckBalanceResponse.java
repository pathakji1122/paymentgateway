package com.example.paymentgateway.payment.Object;

public class CheckBalanceResponse {
    public String balance;
    public Boolean status;

    public CheckBalanceResponse(String balance,Boolean status){
        this.balance=balance;
        this.status=status;
    }
}
