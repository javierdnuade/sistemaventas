package com.proyecto.springboot.sistema_ventas.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Builder
@Entity
@Table(name = "categories")
@Data
public class Category {

    @Id
    private int id;

    @Column(nullable = false)
    private String name;
    
    private String description;
}
