package com.acsistemas.order_manager.shared.dtos.freightCarrier;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

public record FreightCarrierCreateDto(
    @NotBlank(message = "'name' {field.not-empty}")
    String name,

    @NotBlank(message = "'cnpj' {field.not-empty}")
    @CNPJ(message = "cnpj {field.cnpj}")
    String cnpj,

    String contactPhone
) {
}
