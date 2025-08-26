package com.proyecto.springboot.sistema_ventas.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CategoryRequestDTO {

    @NotBlank
    @Size(min = 4, max = 60, message = "El nombre de la categoria debe tener entre 4 y 60 caracteres")
    private String name;

    @NotBlank
    @Size(min = 4, max = 100, message = "La descripcion de la categoria debe tener entre 8 y 100 caracteres")
    private String description;
}
