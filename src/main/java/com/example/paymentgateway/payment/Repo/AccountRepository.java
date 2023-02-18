package com.example.paymentgateway.payment.Repo;

import com.example.paymentgateway.payment.Entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account,String> {
      Account findOneByAccountNo(String accountNo);
      Account findOneByEmail(String email);
      Account save(Account account);

}
