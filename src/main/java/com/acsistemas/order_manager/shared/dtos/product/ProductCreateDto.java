package com.acsistemas.order_manager.shared.dtos.product;

import com.acsistemas.order_manager.api.annotations.AtLeastOneField;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@AtLeastOneField(fields = { "idCode", "barCode" }, message = "{fields} {fields.at-least-one}")
public record ProductCreateDto(
    @NotBlank(message = "'name' {field.not-empty}")
    String name,

    @NotBlank(message = "'description' {field.not-empty}")
    String description,

    String idCode,

    String barCode,

    @NotNull(message = "'price' {field.not-empty}")
    Double price,

    @NotNull(message = "'freightId' {field.not-empty}")
    UUID freightId
) {}
