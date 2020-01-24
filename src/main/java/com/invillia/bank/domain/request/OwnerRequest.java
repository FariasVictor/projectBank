package com.invillia.bank.domain.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OwnerRequest {
    @NotBlank
    private String cpf;
    @NotBlank
    private String name;
}
