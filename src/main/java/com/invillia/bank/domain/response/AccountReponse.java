package com.invillia.bank.domain.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AccountReponse {
    private Long id;
    private Double balance;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

}
