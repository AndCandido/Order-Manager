package com.acsistemas.order_manager.shared.dtos.freightCarrier;

import com.acsistemas.order_manager.domain.entities.FreightCarrier;

import java.time.LocalDateTime;
import java.util.UUID;

public record FreightCarrierResponseDto(
    UUID id,
    String name,
    String cnpj,
    String contactPhone,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public FreightCarrierResponseDto(FreightCarrier freightCarrier) {
        this(
            freightCarrier.getId(),
            freightCarrier.getName(),
            freightCarrier.getCnpj(),
            freightCarrier.getContactPhone(),
            freightCarrier.getCreatedAt(),
            freightCarrier.getUpdatedAt()
        );
    }
}
