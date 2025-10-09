package com.proyecto.springboot.sistema_ventas.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class InvoiceDetailResponseDTO {
    private Integer productId;
    private String productName;
    private int quantity;
}
