package com.acsistemas.order_manager.shared.dtos.product;

import com.acsistemas.order_manager.domain.entities.Product;

import java.time.LocalDateTime;

public record ProductMinResponseDto(
    String name,
    String idCode,
    String barCode,
    Double price,
    LocalDateTime createdAt
) {
    public ProductMinResponseDto(Product product) {
        this(
            product.getName(),
            product.getIdCode(),
            product.getBarCode(),
            product.getPrice(),
            product.getCreatedAt()
        );
    }
}
