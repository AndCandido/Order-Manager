package com.acsistemas.order_manager.shared.dtos.freight;

import com.acsistemas.order_manager.domain.entities.Freight;
import com.acsistemas.order_manager.shared.dtos.address.AddressResponseDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record FreightResponseDto(
    UUID id,
    LocalDateTime shippingDate,
    LocalDateTime deliveryDate,
    boolean isDelivered,
    AddressResponseDto deliveryAddress,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public FreightResponseDto(Freight freight) {
        this(
            freight.getId(),
            freight.getShippingDate(),
            freight.getDeliveryDate(),
            freight.isDelivered(),
            new AddressResponseDto(freight.getDeliveryAddress()),
            freight.getCreatedAt(),
            freight.getUpdatedAt()
        );
    }
}
