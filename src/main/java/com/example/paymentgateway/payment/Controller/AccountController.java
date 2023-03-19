package com.example.paymentgateway.payment.Controller;

import com.example.paymentgateway.payment.Object.*;
import com.example.paymentgateway.payment.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("paymentgateway")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping(path = "addbalance")
    public AddBalanceResponse addBalance(@RequestBody AddBalanceRequest addBalanceRequest) {
        return accountService.addBalance(addBalanceRequest);
    }

    @PostMapping(path = "checkbalance")
    public CheckBalanceResponse checkBalance(@RequestBody CheckBalanceRequest checkBalanceRequest) {
        return accountService.checkBalance(checkBalanceRequest);
    }

    @PostMapping(path = "payment")
    public PaymentResponse orderPayment(@RequestBody PaymentRequest paymentRequest) {
        return accountService.orderPayment(paymentRequest);
    }

    @PostMapping(path = "createaccount")
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
       CreateAccountResponse createAccountResponse= accountService.createAccount(createAccountRequest.email, createAccountRequest.name);
        return createAccountResponse;
    }
}
