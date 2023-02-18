package com.example.paymentgateway.payment.Controller;

import com.example.paymentgateway.payment.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;
    @PostMapping(path = "addbalance")
    public AddBalanceResponse addBalance(@RequestBody AddBalanceRequest addBalanceRequest){
        return accountService.addBalance(addBalanceRequest);
    }
    @PostMapping(path = "checkbalance")
    public CheckBalanceResponse checkBalance(@RequestBody CheckBalanceRequest checkBalanceRequest){
        return accountService.checkBalance(checkBalanceRequest);
    }
    @PostMapping(path = "orderpayment")
    public PaymentResponse orderPayment(@RequestBody PaymentRequest paymentRequest){
        return accountService.orderPayment(paymentRequest);
    }
    @PostMapping (path = "createaccount")
    public CreateAccountResponse createAccount(@RequestBody CreateAccountRequest createAccountRequest){
              return accountService.createAccount(createAccountRequest);
    }
}
