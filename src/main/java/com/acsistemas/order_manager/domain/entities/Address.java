package com.acsistemas.order_manager.domain.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String city;
    private String uf;
    private String publicPlace;
    private String number;
    private String district;
    private String cep;
}
