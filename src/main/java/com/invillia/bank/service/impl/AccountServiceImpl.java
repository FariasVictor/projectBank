package com.invillia.bank.service.impl;

import com.invillia.bank.domain.Account;
import com.invillia.bank.domain.request.AccountRequest;
import com.invillia.bank.domain.response.AccountReponse;
import com.invillia.bank.exception.NotFoundException;
import com.invillia.bank.mapper.AccountMapper;
import com.invillia.bank.repository.AccountRepository;
import com.invillia.bank.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountMapper accountMapper, AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    public List<AccountReponse> findAllAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::accountToAccountReponse).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AccountReponse findAccountById(Long id) throws NotFoundException {
        return accountRepository.findById(id).map(accountMapper::accountToAccountReponse)
                .orElseThrow(() -> new NotFoundException("Conta não encontrada!"));
    }

    @Override
    @Transactional
    public Account createAccount(AccountRequest accountRequest) throws NotFoundException {
        Account account = accountMapper.accountRequestToAccount(accountRequest);
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccountById(Long id) throws NotFoundException {
        Account account = accountRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Não encontrado"));
        accountRepository.delete(account);

    }
}
