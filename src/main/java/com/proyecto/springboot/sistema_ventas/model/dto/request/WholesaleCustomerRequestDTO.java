package com.proyecto.springboot.sistema_ventas.model.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class WholesaleCustomerRequestDTO extends CustomerRequestDTO {

    private String street;
    private Long areaId; // recibimos el ID del área para mapearlo a la entidad
    private String companyName;
}
