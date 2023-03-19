package com.example.paymentgateway.payment.Entity;

import org.springframework.data.annotation.Id;

public class Transaction {
    @Id
    public String transactionId;
    public String date;
    public String accountNo;
}
