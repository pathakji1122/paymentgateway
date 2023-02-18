package com.example.paymentgateway.payment.Service;

import com.example.paymentgateway.payment.Entity.Account;
import com.example.paymentgateway.payment.Repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public AddBalanceResponse addBalance(AddBalanceRequest addBalanceRequest){
        Account account=accountRepository.findOneByAccountNo(addBalanceRequest.accountNo);
        account.balance=account.balance+addBalanceRequest.amount;
        return new AddBalanceResponse(account.balance.toString() +"added successfully");
    }
    public CheckBalanceResponse checkBalance(CheckBalanceRequest checkBalanceRequest){
        Account account=accountRepository.findOneByAccountNo(checkBalanceRequest.accountNo);
        String balance=account.balance.toString();
        return new CheckBalanceResponse("Your balance is : "+ balance);
    }
    public PaymentResponse orderPayment(PaymentRequest paymentRequest){
        Account senderAccount=accountRepository.findOneByAccountNo(paymentRequest.senderAccountNo);
        Account recieverAccount=accountRepository.findOneByAccountNo(paymentRequest.recieverAccountNo);
        if(senderAccount.balance<paymentRequest.amount){
            return new PaymentResponse("Your current balance is low",senderAccount.balance);
        }
        senderAccount.balance=senderAccount.balance-paymentRequest.amount;
        accountRepository.save(senderAccount);
        recieverAccount.balance= recieverAccount.balance+paymentRequest.amount;
        accountRepository.save(recieverAccount);
       return new PaymentResponse("Payment successful",senderAccount.balance);
    }
    public CreateAccountResponse createAccount(CreateAccountRequest createAccountRequest){
      Account account=new Account(createAccountRequest.accountNo,createAccountRequest.email,100);
      accountRepository.save(account);
      return new CreateAccountResponse(account);
    }




}
