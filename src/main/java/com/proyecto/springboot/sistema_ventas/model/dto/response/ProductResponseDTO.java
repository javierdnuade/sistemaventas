package com.proyecto.springboot.sistema_ventas.model.dto.response;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ProductResponseDTO {
    private String name;
    private String code;
    private String descripcion;
    private Integer stock;
    private BigDecimal price;
    private String categoryName;
    private Boolean status;
}