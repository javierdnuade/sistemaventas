package com.proyecto.springboot.sistema_ventas.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@DiscriminatorValue("WHOLESALE")
public class WholesaleCustomer extends Customer {

    private String street;

    private Area area;

    private String companyName;
}
