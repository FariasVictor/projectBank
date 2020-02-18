package com.invillia.bank.domain.request;

import com.invillia.bank.domain.Owner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequest {
    @NotNull
    private Double balance;
    @NotNull
    private Long idOwner;
}
