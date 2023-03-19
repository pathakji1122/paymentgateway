package com.example.paymentgateway.payment.Service;

import com.example.paymentgateway.payment.Entity.Account;
import com.example.paymentgateway.payment.Object.*;
import com.example.paymentgateway.payment.Repo.AccountRepository;
import com.example.paymentgateway.payment.Object.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public AddBalanceResponse addBalance(AddBalanceRequest addBalanceRequest){

        Account account=accountRepository.findOneByEmail(addBalanceRequest.email);
       if(account==null){
           return new AddBalanceResponse("no account with this accountNo",false);
       }
       Integer amountAdd=Integer.parseInt(addBalanceRequest.amount);
        account.balance=account.balance+ amountAdd;
        accountRepository.save(account);

       ;
        return new AddBalanceResponse(addBalanceRequest.amount+" added successfully",true);
    }
    public CheckBalanceResponse checkBalance(CheckBalanceRequest checkBalanceRequest){
        Account account=accountRepository.findOneByEmail(checkBalanceRequest.email);
        if(account==null){
            return new CheckBalanceResponse("No account with this accountNo",false);
        }
        String balance=account.balance.toString();
        return new CheckBalanceResponse("Your balance is : "+ balance,true);
    }
    public PaymentResponse orderPayment(PaymentRequest paymentRequest){
        Account senderAccount=accountRepository.findOneByEmail(paymentRequest.senderEmail);
        Account receiverAccount=accountRepository.findOneByEmail(paymentRequest.receiverEmail);
        if(senderAccount==null||receiverAccount==null){
            return new PaymentResponse("account issue",null,false);
        }
        if(senderAccount.balance<Integer.parseInt(paymentRequest.amount)){
            return new PaymentResponse("Your account balance is low Please add "+(Integer.parseInt(paymentRequest.amount)-senderAccount.balance),senderAccount.balance.toString(),false);
        }
        senderAccount.balance=senderAccount.balance-Integer.parseInt(paymentRequest.amount);
        accountRepository.save(senderAccount);
        receiverAccount.balance= receiverAccount.balance+ Integer.parseInt(paymentRequest.amount);
        accountRepository.save(receiverAccount);
       return new PaymentResponse("Payment successful",senderAccount.balance.toString(),true);
    }
    public CreateAccountResponse createAccount(String email,String name){
        Account account=accountRepository.findOneByEmail(email);
        if(account!=null){
            return new CreateAccountResponse(null,"Account exists",false);
        }
        String accountNo=Util.createAccountNo();
      Account newAccount=new Account(accountNo, name, 100, email);
      accountRepository.save(newAccount);
      return new CreateAccountResponse(accountNo,"Account added",true);
    }




}
