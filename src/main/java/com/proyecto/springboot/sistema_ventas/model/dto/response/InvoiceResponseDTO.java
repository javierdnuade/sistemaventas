package com.proyecto.springboot.sistema_ventas.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class InvoiceResponseDTO {
    private Integer id;
    private LocalDateTime date;
    private Integer customerId;
    private String customerUsername;
    private BigDecimal total;
    private List<InvoiceDetailResponseDTO> invoiceDetails;
}
