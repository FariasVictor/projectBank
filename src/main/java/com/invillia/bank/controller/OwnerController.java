package com.invillia.bank.controller;

import com.invillia.bank.domain.Owner;
import com.invillia.bank.domain.request.OwnerRequest;
import com.invillia.bank.domain.response.OwnerResponse;
import com.invillia.bank.exception.NotFoundException;
import com.invillia.bank.service.impl.OwnerServiceImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerServiceImpl ownerService;

    public OwnerController(OwnerServiceImpl ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<OwnerResponse> findAllOwners(){
        return ownerService.findAllOwners();
    }

    @GetMapping("/{id}")
    public OwnerResponse findById(@PathVariable final Long id) throws NotFoundException {
        return ownerService.findById(id);
    }
    @PostMapping
    public HttpEntity<?> createOwner(
            @RequestBody @Valid final OwnerRequest ownerRequest) throws NotFoundException {
        Owner owner = ownerService.createOwner(ownerRequest);
        final URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/owners/{id}")
                .build(owner.getId());
        return ResponseEntity.created(location).build();
    }
    @PutMapping("/{id}")
    public HttpEntity<?> updateOwner(@PathVariable final Long id, @RequestBody @Valid final OwnerRequest ownerRequest) throws NotFoundException {
        ownerService.update(id, ownerRequest);
        return ResponseEntity.noContent().build();

    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> deleteOwnerById(@PathVariable final Long id) throws NotFoundException {
        ownerService.deleteOwnerById(id);
        return ResponseEntity.noContent().build();
    }
}
