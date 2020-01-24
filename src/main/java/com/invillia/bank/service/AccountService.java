package com.invillia.bank.service;

import com.invillia.bank.domain.Account;
import com.invillia.bank.domain.request.AccountRequest;
import com.invillia.bank.domain.response.AccountReponse;
import com.invillia.bank.exception.NotFoundException;
import com.invillia.bank.exception.TransactionException;

import java.util.List;

public interface AccountService {
    List<AccountReponse> findAllAccounts();
    AccountReponse findAccountById(final Long id) throws NotFoundException;
    Account createAccount(final AccountRequest accountRequest) throws NotFoundException;
    void deleteAccountById(final Long id) throws NotFoundException;
    void withdraw(final Long id, final Double value) throws NotFoundException, TransactionException;
    void deposit(final Long id, final Double value) throws NotFoundException, TransactionException;

}
