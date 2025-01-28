package com.acsistemas.order_manager.shared.dtos.freight;

import com.acsistemas.order_manager.shared.dtos.address.AddressCreateDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record FreightCreateDto(
    LocalDateTime shippingDate,
    LocalDateTime deliveryDate,
    boolean isDelivered,

    UUID freightCarrierId,
    AddressCreateDto deliveryAddress
) {
}
