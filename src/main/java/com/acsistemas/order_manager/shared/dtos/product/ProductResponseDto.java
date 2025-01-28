package com.acsistemas.order_manager.shared.dtos.product;

import com.acsistemas.order_manager.domain.entities.Product;

import java.time.LocalDateTime;
import java.util.UUID;

public record ProductResponseDto(
    UUID id,
    String name,
    String description,
    String idCode,
    String barCode,
    Double price,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {
    public ProductResponseDto(Product product) {
        this(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getIdCode(),
            product.getBarCode(),
            product.getPrice(),
            product.getCreatedAt(),
            product.getUpdatedAt()
        );
    }
}
