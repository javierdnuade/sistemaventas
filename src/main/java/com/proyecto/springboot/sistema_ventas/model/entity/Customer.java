package com.proyecto.springboot.sistema_ventas.model.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@SuperBuilder
@Setter
@Getter
public abstract class Customer extends User {

    private String name;

    private String phone;
}
