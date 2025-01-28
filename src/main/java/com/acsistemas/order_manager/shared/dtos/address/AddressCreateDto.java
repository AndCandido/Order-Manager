package com.acsistemas.order_manager.shared.dtos.address;

public record AddressCreateDto(
    String city,
    String uf,
    String publicPlace,
    String number,
    String district,
    String cep
) {
}
