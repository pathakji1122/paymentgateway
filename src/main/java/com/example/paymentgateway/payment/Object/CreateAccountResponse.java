package com.example.paymentgateway.payment.Object;

import com.example.paymentgateway.payment.Entity.Account;

public class CreateAccountResponse {
    public String accountNo;
    public String response;
    public Boolean status;

    public CreateAccountResponse(String accountNo,String response,Boolean status) {
        this.accountNo=accountNo;
        this.response=response;
        this.status=status;
    }
}
