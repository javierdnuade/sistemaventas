package com.proyecto.springboot.sistema_ventas.model.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.experimental.SuperBuilder;

@SuperBuilder
public class RetailCustomerRequestDTO  {

    @NotNull(message = "El DNI es obligatorio")
    @Min(value = 1000000, message = "El DNI debe tener al menos 7 dígitos")
    @Max(value = 999999999, message = "El DNI no puede tener más de 9 dígitos")
    private Integer dni;
}
