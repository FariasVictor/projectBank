package com.invillia.bank.mapper;

import com.invillia.bank.domain.Account;
import com.invillia.bank.domain.request.AccountRequest;
import com.invillia.bank.domain.response.AccountReponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {
    public AccountReponse accountToAccountReponse(final Account account){
        return AccountReponse.builder().id(account.getId())
                .balance(account.getBalance())
                .build();
    }
    public List<AccountReponse> accountToAccountResponse(final List<Account> accounts) {
        return accounts.stream().map(this::accountToAccountReponse).collect(Collectors.toList());
    }
    public Account accountRequestToAccount(final AccountRequest accountRequest) {
        Account account = new Account();
        account.setBalance(accountRequest.getBalance());
        return account;
    }
}
