package com.example.paymentgateway.payment.Service;

import com.example.paymentgateway.payment.Entity.Account;

public class CreateAccountResponse {
    public Account account;
    public CreateAccountResponse(Account account) {
        this.account=account;
    }
}
