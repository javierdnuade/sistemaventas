package com.proyecto.springboot.sistema_ventas.model.entity;

import java.util.List;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class Customer extends User {

    private String name;

    private String phone;

    private List<Invoice> invoices;
}
