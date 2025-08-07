package com.proyecto.springboot.sistema_ventas.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "areas")
@Data
public class Area {

    @Id
    private int id;

    private String name;
}
