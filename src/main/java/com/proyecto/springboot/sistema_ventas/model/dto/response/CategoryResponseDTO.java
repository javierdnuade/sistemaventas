package com.proyecto.springboot.sistema_ventas.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponseDTO {

    private String name;

    private String description;
}
