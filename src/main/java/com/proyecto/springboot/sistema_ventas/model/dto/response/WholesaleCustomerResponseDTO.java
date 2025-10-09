package com.proyecto.springboot.sistema_ventas.model.dto.response;

import com.proyecto.springboot.sistema_ventas.model.entity.Area;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
public class WholesaleCustomerResponseDTO extends CustomerResponseDTO{

    private Area area;

    private String companyName;
}
