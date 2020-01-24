package com.invillia.bank.service;

import com.invillia.bank.domain.Owner;
import com.invillia.bank.domain.request.OwnerRequest;
import com.invillia.bank.domain.response.OwnerResponse;
import com.invillia.bank.exception.NotFoundException;

import java.util.List;

public interface OwnerService {
    List<OwnerResponse> findAllOwners();
    OwnerResponse findById(final Long id) throws NotFoundException;
    Owner createOwner(final OwnerRequest ownerRequest) throws NotFoundException;;
    void update(final Long id, final OwnerRequest ownerRequest) throws NotFoundException;;
    void deleteOwnerById(final Long id) throws NotFoundException;;


}
