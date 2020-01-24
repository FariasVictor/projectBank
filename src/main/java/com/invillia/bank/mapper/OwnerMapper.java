package com.invillia.bank.mapper;

import com.invillia.bank.domain.Owner;
import com.invillia.bank.domain.request.OwnerRequest;
import com.invillia.bank.domain.response.OwnerResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OwnerMapper {
    public OwnerResponse ownerToOwnerResponse(final Owner owner){
        return OwnerResponse.builder()
                .id(owner.getId())
                .cpf(owner.getCpf())
                .name(owner.getName())
                .accounts(owner.getAccounts())
                .createdAt(owner.getCreatedAt())
                .updatedAt(owner.getUpdatedAt())
                .build();
    }
    public List<OwnerResponse> ownerToOwnerResponse(final List<Owner> owners){
        return owners.stream()
                .map(this::ownerToOwnerResponse)
                .collect(Collectors.toList());
    }
    public Owner ownerRequestToOwner(final OwnerRequest ownerRequest){
        return Owner.builder()
                .cpf(ownerRequest.getCpf())
                .name(ownerRequest.getName())
                .build();
    }
    public Owner updateOwnerByOwnerRequest(final Owner owner, final OwnerRequest ownerRequest){
        return Owner.builder()
                .cpf(ownerRequest.getCpf())
                .name(ownerRequest.getName())
                .build();
    }
}
