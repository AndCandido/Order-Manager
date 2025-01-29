package com.acsistemas.order_manager.web.controllers;

import com.acsistemas.order_manager.domain.services.ProductService;
import com.acsistemas.order_manager.shared.dtos.api.ResourceIdResponseDto;
import com.acsistemas.order_manager.shared.dtos.product.ProductCreateDto;
import com.acsistemas.order_manager.shared.dtos.product.ProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResourceIdResponseDto<UUID> saveProduct(@RequestBody ProductCreateDto productCreateDto) {
        return productService.saveProduct(productCreateDto);
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProduct(@PathVariable UUID id) {
        return productService.getProductByIdOrThrow(id);
    }
}
