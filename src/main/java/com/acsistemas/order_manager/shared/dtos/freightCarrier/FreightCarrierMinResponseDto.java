package com.acsistemas.order_manager.shared.dtos.freightCarrier;

import com.acsistemas.order_manager.domain.entities.FreightCarrier;

import java.time.LocalDateTime;

public record FreightCarrierMinResponseDto(
    String name,
    String cnpj,
    String phone,
    LocalDateTime createdAt
) {
    public FreightCarrierMinResponseDto(FreightCarrier freightCarrier) {
        this(
            freightCarrier.getName(),
            freightCarrier.getCnpj(),
            freightCarrier.getPhone(),
            freightCarrier.getCreatedAt()
        );
    }
}
