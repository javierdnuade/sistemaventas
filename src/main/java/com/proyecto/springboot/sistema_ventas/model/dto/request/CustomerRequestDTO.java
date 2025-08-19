package com.proyecto.springboot.sistema_ventas.model.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class CustomerRequestDTO extends UserRequestDTO {

    private String name;
    private String phone;
}
