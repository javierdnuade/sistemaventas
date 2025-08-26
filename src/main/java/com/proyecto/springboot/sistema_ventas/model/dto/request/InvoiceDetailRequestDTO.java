package com.proyecto.springboot.sistema_ventas.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class InvoiceDetailRequestDTO {

    @NotNull(message = "El ID del producto es obligatorio")
    private Integer productId;

    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private int quantity;
}
