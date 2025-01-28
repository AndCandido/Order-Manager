package com.acsistemas.order_manager.shared.dtos.product;

import java.util.UUID;

public record ProductCreateDto(
    String name,
    String description,
    String idCode,
    String barCode,
    Double price,
    UUID freightId
) {}
