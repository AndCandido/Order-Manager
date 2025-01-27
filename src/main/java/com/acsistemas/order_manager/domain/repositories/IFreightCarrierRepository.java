package com.acsistemas.order_manager.domain.repositories;

import com.acsistemas.order_manager.domain.entities.FreightCarrier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IFreightCarrierRepository extends JpaRepository<FreightCarrier, UUID> {
}
