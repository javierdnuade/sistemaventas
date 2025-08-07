package com.proyecto.springboot.sistema_ventas.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("RETAIL")
public class RetailCustomer extends Customer {

}
