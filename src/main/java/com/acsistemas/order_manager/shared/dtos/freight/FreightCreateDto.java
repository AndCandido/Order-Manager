package com.acsistemas.order_manager.shared.dtos.freight;

import com.acsistemas.order_manager.shared.dtos.address.AddressCreateDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record FreightCreateDto(

    @NotNull(message = "'shippingDate' {field.not-empty}")
    LocalDateTime shippingDate,

    @NotNull(message = "'deliveryDate' {field.not-empty}")
    LocalDateTime deliveryDate,

    @NotNull(message = "'isDelivered' {field.not-empty}")
    boolean isDelivered,

    @NotNull(message = "'freightCarrierId' {field.not-empty}")
    UUID freightCarrierId,

    @NotNull(message = "'deliveryAddress' {field.not-empty}")
    @Valid AddressCreateDto deliveryAddress
) {
}
