package com.proyecto.springboot.sistema_ventas.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("RETAIL")
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
public class RetailCustomer extends Customer {

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true) // Indicamos el nombre del atributo en Invoice que mapea la relacion
    private List<Invoice> invoices;
}
