package com.proyecto.springboot.sistema_ventas.model.dto.response;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class InvoiceDetailResponseDTO {
    private String productName;
    private int quantity;
    private BigDecimal line_total;
}
