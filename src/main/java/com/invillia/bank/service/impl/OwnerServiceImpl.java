package com.invillia.bank.service.impl;


import com.invillia.bank.domain.Owner;
import com.invillia.bank.domain.request.OwnerRequest;
import com.invillia.bank.domain.response.OwnerResponse;
import com.invillia.bank.exception.NotFoundException;
import com.invillia.bank.mapper.OwnerMapper;
import com.invillia.bank.repository.OwnerRepository;
import com.invillia.bank.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    private OwnerMapper ownerMapper;
    private OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerMapper ownerMapper, OwnerRepository ownerRepository) {
        this.ownerMapper = ownerMapper;
        this.ownerRepository = ownerRepository;
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
        return ownerRepository.save(owner);
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
