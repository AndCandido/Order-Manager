package com.acsistemas.order_manager.shared.dtos.address;

import jakarta.validation.constraints.NotBlank;

public record AddressCreateDto(
    @NotBlank(message = "'city' {field.not-empty}")
    String city,
    @NotBlank(message = "'uf' {field.not-empty}")
    String uf,
    @NotBlank(message = "'publicPlace' {field.not-empty}")
    String publicPlace,
    @NotBlank(message = "'number' {field.not-empty}")
    String number,
    @NotBlank(message = "'district' {field.not-empty}")
    String district,
    @NotBlank(message = "'cep' {field.not-empty}")
    String cep
) {
}
