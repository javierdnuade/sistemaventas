package com.proyecto.springboot.sistema_ventas.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.experimental.SuperBuilder;

@SuperBuilder

public class WholesaleCustomerRequestDTO extends CustomerRequestDTO {

    @NotBlank
    @Size(min = 8, max = 100, message = "La direccion debe tener entre 8 y 100 caracteres")
    private String street;

    @NotNull(message = "El área es obligatoria")
    @Min(value = 1, message = "El ID del área debe ser mayor a 0")
    private Integer areaId; // recibimos el ID del área para mapearlo a la entidad

    @NotBlank
    @Size(min = 4, max = 60, message = "El nombre de la compania debe tener entre 4 y 60 caracteres")
    private String companyName;
}
