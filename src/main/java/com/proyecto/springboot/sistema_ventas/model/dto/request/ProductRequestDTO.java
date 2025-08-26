package com.proyecto.springboot.sistema_ventas.model.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ProductRequestDTO {

    @NotBlank
    @Size(min = 4, max = 60, message = "El nombre del producto debe contener entre 4 y 60 caracteres")
    private String name;

    @NotBlank
    @Size(min = 8, max = 100, message = "La descripcion del producto debe contener entre 8 y 100 caracteres")
    private String description;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "El precio no puede ser negativo")
    private BigDecimal price;

    @NotNull(message = "El ID del producto es obligatorio")
    private Integer categoryId;

    @NotNull(message = "El status es obligatorio")
    private Boolean status;
}
