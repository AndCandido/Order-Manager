package com.acsistemas.order_manager.domain.repositories;

import com.acsistemas.order_manager.domain.entities.Freight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IFreightRepository extends JpaRepository<Freight, UUID> {
}
