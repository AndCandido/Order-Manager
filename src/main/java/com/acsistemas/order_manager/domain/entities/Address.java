package com.acsistemas.order_manager.domain.entities;

import com.acsistemas.order_manager.shared.dtos.address.AddressCreateDto;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {
    private String city;
    private String uf;
    private String publicPlace;
    private String number;
    private String district;
    private String cep;

    public Address(AddressCreateDto dto) {
        this.city = dto.city();
        this.uf = dto.uf();
        this.publicPlace = dto.publicPlace();
        this.number = dto.number();
        this.district= dto.district();
        this.cep = dto.cep();
    }
}
