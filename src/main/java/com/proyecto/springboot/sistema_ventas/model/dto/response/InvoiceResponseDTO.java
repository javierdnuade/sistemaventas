package com.proyecto.springboot.sistema_ventas.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class InvoiceResponseDTO {
    private Integer id;
    private LocalDateTime date;
    private Integer customerId;
    private String customerUsername;
    private List<InvoiceDetailResponseDTO> invoiceDetails;
}
