package com.acsistemas.order_manager.domain.services;

import com.acsistemas.order_manager.config.exceptions.ResourceNotFoundException;
import com.acsistemas.order_manager.domain.entities.FreightCarrier;
import com.acsistemas.order_manager.domain.repositories.IFreightCarrierRepository;
import com.acsistemas.order_manager.shared.dtos.freightCarrier.FreightCarrierCreateDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FreightCarrierService {
    private IFreightCarrierRepository freightCarrierRepository;

    public void saveFreightCarrier(FreightCarrierCreateDto freightCarrierDto) {
        FreightCarrier freightCarrierToSave = new FreightCarrier(freightCarrierDto);
        freightCarrierRepository.save(freightCarrierToSave);
    }

    public FreightCarrier getFreightCarrierByIdOrThrow(UUID freightCarrierId) {
        return freightCarrierRepository.findById(freightCarrierId)
            .orElseThrow(() -> new ResourceNotFoundException("Freight Carrier Not Found"));
    }
}
