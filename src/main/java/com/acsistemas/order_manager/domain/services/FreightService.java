package com.acsistemas.order_manager.domain.services;

import com.acsistemas.order_manager.api.exceptions.ResourceNotFoundException;
import com.acsistemas.order_manager.domain.entities.Address;
import com.acsistemas.order_manager.domain.entities.Freight;
import com.acsistemas.order_manager.domain.entities.FreightCarrier;
import com.acsistemas.order_manager.domain.repositories.IFreightRepository;
import com.acsistemas.order_manager.shared.dtos.api.ResourceIdResponseDto;
import com.acsistemas.order_manager.shared.dtos.freight.FreightCreateDto;
import com.acsistemas.order_manager.shared.dtos.freight.FreightMinResponseDto;
import com.acsistemas.order_manager.shared.dtos.freight.FreightResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FreightService {
    private final IFreightRepository freightRepository;
    private final FreightCarrierService freightCarrierService;

    public Freight findFreightByIdOrThrow(UUID freightId) {
        return freightRepository.findById(freightId)
            .orElseThrow(() -> new ResourceNotFoundException("Freight Not Found"));
    }

    public FreightResponseDto getFreightByIdOrThrow(UUID freightId) {
        Freight freightFound = findFreightByIdOrThrow(freightId);
        return new FreightResponseDto(freightFound);
    }

    public ResourceIdResponseDto<UUID> saveFreight(FreightCreateDto freightCreateDto) {
        var freightCarrierId = freightCreateDto.freightCarrierId();
        FreightCarrier freightCarrier = freightCarrierService.findFreightCarrierByIdOrThrow(freightCarrierId);
        Address deliveryAddress = new Address(freightCreateDto.deliveryAddress());
        Freight freightToSave = new Freight(freightCreateDto, freightCarrier, deliveryAddress);
        freightRepository.save(freightToSave);
        return new ResourceIdResponseDto<>(freightToSave.getId());
    }

    public List<FreightMinResponseDto> getAllFreights() {
        return freightRepository.findAll().stream().map(FreightMinResponseDto::new).toList();
    }
}
