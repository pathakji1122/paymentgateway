package com.example.paymentgateway.payment.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Payment")

public class Account {
    @Id
    public String accountNo;
    public Integer balance;
    public String email;
    public String name;

    public Account(String accountNo,String name,Integer balance,String email) {
        this.balance=balance;
        this.email=email;
        this.accountNo=accountNo;
        this.name=name;
    }
}
