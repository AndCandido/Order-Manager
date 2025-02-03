package com.acsistemas.order_manager.shared.dtos.freight;


import com.acsistemas.order_manager.domain.entities.Freight;

import java.time.LocalDateTime;

public record FreightMinResponseDto(
    LocalDateTime shippingDate,
    LocalDateTime deliveryDate,
    boolean isDelivered,
    String city,
    String publicPlace,
    String number,
    String cep
) {
    public  FreightMinResponseDto(Freight freight) {
        this(
            freight.getShippingDate(),
            freight.getDeliveryDate(),
            freight.isDelivered(),
            freight.getDeliveryAddress().getCity(),
            freight.getDeliveryAddress().getPublicPlace(),
            freight.getDeliveryAddress().getNumber(),
            freight.getDeliveryAddress().getCep()
        );
    }
}
