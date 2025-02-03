package com.acsistemas.order_manager.shared.dtos.freightCarrier;

import com.acsistemas.order_manager.api.annotations.AtLeastOneField;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

@AtLeastOneField(fields = { "email", "phone" }, message = "{fields} {fields.at-least-one}")
public record FreightCarrierCreateDto(
    @NotBlank(message = "'name' {field.not-empty}")
    String name,

    @NotBlank(message = "'cnpj' {field.not-empty}")
    @CNPJ(message = "{field.cnpj}")
    String cnpj,

    @Email(message = "{field.email}")
    String email,

    String phone
) {
}
