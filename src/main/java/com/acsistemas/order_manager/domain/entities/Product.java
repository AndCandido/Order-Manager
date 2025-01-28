package com.acsistemas.order_manager.domain.entities;

import com.acsistemas.order_manager.shared.dtos.product.ProductCreateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_products")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;
    private String idCode;
    private String barCode;
    private Double price;

    @ManyToOne
    private Freight freight;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Product(ProductCreateDto dto, Freight freight) {
        this.name = dto.name();
        this.description = dto.description();
        this.idCode = dto.idCode();
        this.barCode = dto.barCode();
        this.price = dto.price();
        this.freight = freight;
    }
}
