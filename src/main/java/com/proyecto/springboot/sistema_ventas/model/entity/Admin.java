package com.proyecto.springboot.sistema_ventas.model.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

}