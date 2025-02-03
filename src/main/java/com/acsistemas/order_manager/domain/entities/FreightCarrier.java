package com.acsistemas.order_manager.domain.entities;

import com.acsistemas.order_manager.shared.dtos.freightCarrier.FreightCarrierCreateDto;
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
@Table(name = "tb_freight_carriers")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FreightCarrier {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String cnpj;
    private String phone;
    private String email;

    @OneToMany
    private List<Freight> pendingFreights;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public FreightCarrier(FreightCarrierCreateDto dto) {
        this.name = dto.name();
        this.cnpj = dto.cnpj();
        this.phone = dto.phone();
        this.email = dto.email();
    }
}
