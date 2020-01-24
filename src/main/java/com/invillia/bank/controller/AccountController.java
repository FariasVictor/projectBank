package com.invillia.bank.controller;

import com.invillia.bank.domain.Account;
import com.invillia.bank.domain.request.AccountRequest;
import com.invillia.bank.domain.response.AccountReponse;
import com.invillia.bank.exception.NotFoundException;
import com.invillia.bank.service.impl.AccountServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountServiceImpl accountService;

    public AccountController(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountReponse> findAllAccounts(){
        return accountService.findAllAccounts();
    }
    @GetMapping("/{id}")
    public AccountReponse findAccountById(@PathVariable final Long id) throws NotFoundException {
        return accountService.findAccountById(id);
    }
    @PostMapping
    public HttpEntity<?> createAccount(
            @RequestBody @Valid final AccountRequest accountRequest
    ) throws NotFoundException {

        Account account = accountService.createAccount(accountRequest);

        final URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/accounts/{id}")
                .build(account.getId());

        return ResponseEntity.created(location).build();

    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteAccountById(@PathVariable final Long id) throws NotFoundException {
        accountService.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }

}
