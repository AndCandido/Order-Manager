package com.acsistemas.order_manager.domain.services;

import com.acsistemas.order_manager.config.exceptions.ResourceNotFoundException;
import com.acsistemas.order_manager.domain.entities.Freight;
import com.acsistemas.order_manager.domain.entities.Product;
import com.acsistemas.order_manager.domain.repositories.IProductRepository;
import com.acsistemas.order_manager.shared.dtos.product.ProductCreateDto;
import com.acsistemas.order_manager.shared.dtos.product.ProductResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {
    private IProductRepository productRepository;
    private FreightService freightService;

    public void saveProduct(ProductCreateDto productCreateDto) {
        Freight freightFound = freightService.getFreightByIdOrThrow(productCreateDto.freightId());
        Product productToSave = new Product(productCreateDto, freightFound);
        productRepository.save(productToSave);
    }

    public ProductResponseDto getProductByIdOrThrow(UUID id) {
        Product product = findProductByIdOrThrow(id);
        return new ProductResponseDto(product);
    }

    private Product findProductByIdOrThrow(UUID id) {
        return productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
    }
}
