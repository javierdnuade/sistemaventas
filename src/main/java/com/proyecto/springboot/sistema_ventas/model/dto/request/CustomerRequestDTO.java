package com.proyecto.springboot.sistema_ventas.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public abstract class CustomerRequestDTO extends UserRequestDTO {

    @NotBlank
    @Size(min = 4, max = 60, message = "El nombre del cliente debe tener entre 4 y 60 caracteres")
    private String name;

    @NotBlank
    @Size(min = 8, max = 20, message = "El número debe tener entre 8 y 20 dígitos")
    private String phone;
}
