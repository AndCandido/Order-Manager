package com.acsistemas.order_manager.domain.services;

import com.acsistemas.order_manager.api.exceptions.ResourceNotFoundException;
import com.acsistemas.order_manager.domain.entities.Freight;
import com.acsistemas.order_manager.domain.entities.Product;
import com.acsistemas.order_manager.domain.repositories.IProductRepository;
import com.acsistemas.order_manager.shared.dtos.api.ResourceIdResponseDto;
import com.acsistemas.order_manager.shared.dtos.product.ProductCreateDto;
import com.acsistemas.order_manager.shared.dtos.product.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final IProductRepository productRepository;
    private final FreightService freightService;

    public ResourceIdResponseDto<UUID> saveProduct(ProductCreateDto productCreateDto) {
        Freight freightFound = freightService.findFreightByIdOrThrow(productCreateDto.freightId());
        Product productToSave = new Product(productCreateDto, freightFound);
        productRepository.save(productToSave);
        return new ResourceIdResponseDto<>(productToSave.getId());
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
