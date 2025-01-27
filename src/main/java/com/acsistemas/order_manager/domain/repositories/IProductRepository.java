package com.acsistemas.order_manager.domain.repositories;

import com.acsistemas.order_manager.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IProductRepository extends JpaRepository<Product, UUID> {
}
