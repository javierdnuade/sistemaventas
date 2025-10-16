package com.proyecto.springboot.sistema_ventas.model.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class InvoiceRequestDTO {
    /* Obtenemos al usuario desde la sesion
    @NotNull(message = "El ID del cliente es obligatorio")
    private Integer customerId;
    */
    @NotEmpty(message = "La lista debe tener como minimo 1 producto")
    private List<InvoiceDetailRequestDTO> items;
}
