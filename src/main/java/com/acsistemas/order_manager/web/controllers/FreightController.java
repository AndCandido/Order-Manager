package com.acsistemas.order_manager.web.controllers;

import com.acsistemas.order_manager.domain.services.FreightService;
import com.acsistemas.order_manager.shared.dtos.api.ResourceIdResponseDto;
import com.acsistemas.order_manager.shared.dtos.freight.FreightCreateDto;
import com.acsistemas.order_manager.shared.dtos.freight.FreightResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/freights")
@RequiredArgsConstructor
public class FreightController {
    private final FreightService freightService;

    @PostMapping
    public ResourceIdResponseDto<UUID> saveFreight(@Valid @RequestBody FreightCreateDto freightCreateDto) {
        return freightService.saveFreight(freightCreateDto);
    }

    @GetMapping("/{id}")
    public FreightResponseDto getFreight(@PathVariable UUID id) {
        return freightService.getFreightByIdOrThrow(id);
    }
}
