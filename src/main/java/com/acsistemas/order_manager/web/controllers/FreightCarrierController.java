package com.acsistemas.order_manager.web.controllers;

import com.acsistemas.order_manager.domain.services.FreightCarrierService;
import com.acsistemas.order_manager.shared.dtos.api.ResourceIdResponseDto;
import com.acsistemas.order_manager.shared.dtos.freightCarrier.FreightCarrierCreateDto;
import com.acsistemas.order_manager.shared.dtos.freightCarrier.FreightCarrierMinResponseDto;
import com.acsistemas.order_manager.shared.dtos.freightCarrier.FreightCarrierResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/freight-carriers")
@RequiredArgsConstructor
public class FreightCarrierController {
    private final FreightCarrierService freightCarrierService;

    @PostMapping
    public ResourceIdResponseDto<UUID> saveFreightCarrier(@Valid @RequestBody FreightCarrierCreateDto freightCarrierCreateDto) {
        return freightCarrierService.saveFreightCarrier(freightCarrierCreateDto);
    }

    @GetMapping("/{id}")
    public FreightCarrierResponseDto getFreightCarrierById(@PathVariable UUID id) {
        return freightCarrierService.getFreightCarrierByIdOrThrow(id);
    }

    @GetMapping
    public List<FreightCarrierMinResponseDto> getAllFreightCarriers() {
        return freightCarrierService.getAllFreightCarriers();
    }
}
