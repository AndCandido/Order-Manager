package com.acsistemas.order_manager.shared.dtos.freightCarrier;

public record FreightCarrierCreateDto(
    String name,
    String cnpj,
    String contactPhone
) {
}
