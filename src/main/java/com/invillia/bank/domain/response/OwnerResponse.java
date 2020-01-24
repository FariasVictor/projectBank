package com.invillia.bank.domain.response;

import com.invillia.bank.domain.Account;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class OwnerResponse {
    private Long id;
    private String cpf;
    private String name;
    private List<Account> accounts;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
