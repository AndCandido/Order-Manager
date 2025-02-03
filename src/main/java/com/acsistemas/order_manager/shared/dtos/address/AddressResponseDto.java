package com.acsistemas.order_manager.shared.dtos.address;

import com.acsistemas.order_manager.domain.entities.Address;

public record AddressResponseDto(
    String city,
    String uf,
    String publicPlace,
    String number,
    String district,
    String cep
) {
    public AddressResponseDto(Address address) {
        this(
            address.getCity(),
            address.getUf(),
            address.getPublicPlace(),
            address.getNumber(),
            address.getDistrict(),
            address.getCep()
        );
    }
}
