package com.acsistemas.order_manager.domain.services;

import com.acsistemas.order_manager.config.exceptions.ResourceNotFoundException;
import com.acsistemas.order_manager.domain.entities.Address;
import com.acsistemas.order_manager.domain.entities.Freight;
import com.acsistemas.order_manager.domain.entities.FreightCarrier;
import com.acsistemas.order_manager.domain.repositories.IFreightRepository;
import com.acsistemas.order_manager.shared.dtos.freight.FreightCreateDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class FreightService {
    private IFreightRepository freightRepository;
    private FreightCarrierService freightCarrierService;

    public Freight getFreightByIdOrThrow(UUID freightId) {
        return freightRepository.findById(freightId)
            .orElseThrow(() -> new ResourceNotFoundException("Freight Not Found"));
    }

    public void saveFreight(FreightCreateDto freightCreateDto) {
        var freightCarrierId = freightCreateDto.freightCarrierId();
        FreightCarrier freightCarrier = freightCarrierService.getFreightCarrierByIdOrThrow(freightCarrierId);
        Address deliveryAddress = new Address(freightCreateDto.deliveryAddress());
        Freight freightToSave = new Freight(freightCreateDto, freightCarrier, deliveryAddress);
        freightRepository.save(freightToSave);
    }
}
