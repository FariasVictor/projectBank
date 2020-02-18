package com.invillia.bank.service.impl;


import com.invillia.bank.domain.Account;
import com.invillia.bank.domain.Owner;
import com.invillia.bank.domain.request.AccountRequest;
import com.invillia.bank.domain.request.OwnerRequest;
import com.invillia.bank.domain.response.OwnerResponse;
import com.invillia.bank.exception.NotFoundException;
import com.invillia.bank.mapper.AccountMapper;
import com.invillia.bank.mapper.OwnerMapper;
import com.invillia.bank.repository.AccountRepository;
import com.invillia.bank.repository.OwnerRepository;
import com.invillia.bank.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerMapper ownerMapper;
    private OwnerRepository ownerRepository;
    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    public OwnerServiceImpl(OwnerMapper ownerMapper, OwnerRepository ownerRepository, AccountRepository accountRepository, AccountMapper accountMapper) {
        this.ownerMapper = ownerMapper;
        this.ownerRepository = ownerRepository;
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<OwnerResponse> findAllOwners() {
        return ownerRepository.findAll().stream().map(ownerMapper::ownerToOwnerResponse).collect(Collectors.toList());
    }

    @Override
    public OwnerResponse findById(Long id) throws NotFoundException {
        return ownerRepository.findById(id).map(ownerMapper::ownerToOwnerResponse)
                .orElseThrow(() -> new NotFoundException("Account not found!"));
    }

    @Override
    public Owner createOwner(OwnerRequest ownerRequest) throws NotFoundException {
        Owner owner = ownerMapper.ownerRequestToOwner(ownerRequest);
        ownerRepository.save(owner);

        Account account = accountMapper.accountRequestToAccount(new AccountRequest(0.0,owner.getId()));
        account.setOwner(owner);
        accountRepository.save(account);

        return owner;
    }

    @Override
    public void update(Long id, OwnerRequest ownerRequest) throws NotFoundException {
        final Owner owner = ownerRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Not found")
        );
        ownerMapper.updateOwnerByOwnerRequest(owner, ownerRequest);
        ownerRepository.save(owner);
    }

    @Override
    public void deleteOwnerById(Long id) throws NotFoundException {
        Owner owner = ownerRepository
                .findById(id)
                .orElseThrow(()-> new NotFoundException("Not found"));
        ownerRepository.delete(owner);
    }
}
