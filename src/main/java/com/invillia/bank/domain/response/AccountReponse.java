package com.invillia.bank.domain.response;

import com.invillia.bank.domain.Owner;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AccountReponse {
    private Long id;
    private String accountNumber;
    private Double balance;
    private Owner owner;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
