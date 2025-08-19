package com.proyecto.springboot.sistema_ventas.model.entity.embeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInvoice {

    private int productId;
    private int invoiceId;
}
