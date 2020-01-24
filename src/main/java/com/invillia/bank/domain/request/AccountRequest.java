package com.invillia.bank.domain.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class AccountRequest {
    @NotNull
    private Double balance;
}
