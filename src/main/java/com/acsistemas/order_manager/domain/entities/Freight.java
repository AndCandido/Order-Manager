package com.acsistemas.order_manager.domain.entities;

import com.acsistemas.order_manager.shared.dtos.freight.FreightCreateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tb_freights")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Freight {
    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime shippingDate;
    private LocalDateTime deliveryDate;
    private boolean isDelivered;

    @ManyToOne
    private FreightCarrier freightCarrier;
    @OneToMany
    private List<Product> products;
    @Embedded
    private Address deliveryAddress;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Freight(FreightCreateDto dto, FreightCarrier freightCarrier, Address deliveryAddress) {
        this.shippingDate = dto.shippingDate();
        this.deliveryDate = dto.deliveryDate();
        this.isDelivered = dto.isDelivered();
        this.freightCarrier = freightCarrier;
        this.deliveryAddress = deliveryAddress;
    }
}
