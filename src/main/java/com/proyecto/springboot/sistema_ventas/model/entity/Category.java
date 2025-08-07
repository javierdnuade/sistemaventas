package com.proyecto.springboot.sistema_ventas.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    private int id;

    private String name;
    
    private String description;
}
