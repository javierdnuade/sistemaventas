package com.proyecto.springboot.sistema_ventas.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;


@Entity
@DiscriminatorValue("WHOLESALE")
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Data
public class WholesaleCustomer extends Customer {

    private String street;

    @ManyToOne
    @JoinColumn(name = "id_area", nullable = false)
    private Area area;

    private String companyName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices;
}
