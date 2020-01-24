package com.invillia.bank.domain.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class TransactionRequest {
    @NotNull(message="Adicione um valor valido")
    private Double value;
}
