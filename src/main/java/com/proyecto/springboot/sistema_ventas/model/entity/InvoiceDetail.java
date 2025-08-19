package com.proyecto.springboot.sistema_ventas.model.entity;

import com.proyecto.springboot.sistema_ventas.model.entity.embeddable.UserInvoice;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "invoice_detail")
@Data
public class InvoiceDetail {

    @EmbeddedId
    private UserInvoice id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @MapsId("invoiceId")
    @JoinColumn(name = "id_invoice")
    private Invoice invoice;

    @Column(nullable = false)
    private int quantity;

}
