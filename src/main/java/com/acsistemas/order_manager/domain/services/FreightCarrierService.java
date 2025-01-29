package com.acsistemas.order_manager.domain.services;

import com.acsistemas.order_manager.config.exceptions.ResourceNotFoundException;
import com.acsistemas.order_manager.domain.entities.FreightCarrier;
import com.acsistemas.order_manager.domain.repositories.IFreightCarrierRepository;
import com.acsistemas.order_manager.shared.dtos.api.ResourceIdResponseDto;
import com.acsistemas.order_manager.shared.dtos.freightCarrier.FreightCarrierCreateDto;
import com.acsistemas.order_manager.shared.dtos.freightCarrier.FreightCarrierResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FreightCarrierService {
    private final IFreightCarrierRepository freightCarrierRepository;

    public ResourceIdResponseDto<UUID> saveFreightCarrier(FreightCarrierCreateDto freightCarrierDto) {
        FreightCarrier freightCarrierToSave = new FreightCarrier(freightCarrierDto);
        freightCarrierRepository.save(freightCarrierToSave);
        return new ResourceIdResponseDto<>(freightCarrierToSave.getId());
    }

    public FreightCarrierResponseDto getFreightCarrierByIdOrThrow(UUID freightCarrierId) {
        FreightCarrier freightCarrierFound = findFreightCarrierByIdOrThrow(freightCarrierId);
        return new FreightCarrierResponseDto(freightCarrierFound);
    }

    public FreightCarrier findFreightCarrierByIdOrThrow(UUID freightCarrierId) {
        return freightCarrierRepository.findById(freightCarrierId)
            .orElseThrow(() -> new ResourceNotFoundException("Freight Carrier Not Found"));
    }
}
