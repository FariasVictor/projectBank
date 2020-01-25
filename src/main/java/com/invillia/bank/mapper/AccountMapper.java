package com.invillia.bank.mapper;

import com.invillia.bank.domain.Account;
import com.invillia.bank.domain.Owner;
import com.invillia.bank.domain.request.AccountRequest;
import com.invillia.bank.domain.response.AccountReponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountMapper {
    public AccountReponse accountToAccountReponse(final Account account){
        return AccountReponse.builder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber())
                .owner(account.getOwner())
                .balance(account.getBalance())
                .createdAt(account.getCreatedAt())
                .updatedAt(account.getUpdatedAt())
                .build();
    }
    public List<AccountReponse> accountToAccountResponse(final List<Account> accounts) {
        return accounts.stream().map(this::accountToAccountReponse).collect(Collectors.toList());
    }
    public Account accountRequestToAccount(final AccountRequest accountRequest) {
        Account account = new Account();
        return account.builder()
                .accountNumber(accountRequest.getAccountNumber())
                .balance(accountRequest.getBalance()).owner(Owner.builder().id(accountRequest.getIdOwner()).build())
                .build();
    }
}
