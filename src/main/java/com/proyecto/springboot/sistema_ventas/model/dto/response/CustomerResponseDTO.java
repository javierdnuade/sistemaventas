package com.proyecto.springboot.sistema_ventas.model.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
public class CustomerResponseDTO extends UserResponseDTO {
    private String name;
    private String phone;
}
