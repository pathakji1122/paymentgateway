package com.example.paymentgateway.payment.Entity;

import org.springframework.data.annotation.Id;

public class Account {
    @Id
    public String accountNo;
    public Integer balance;
    public String email;

    public Account(String accountNo, String email, int balance) {
        this.balance=balance;
        this.accountNo=accountNo;
        this.email=email;
    }
}
