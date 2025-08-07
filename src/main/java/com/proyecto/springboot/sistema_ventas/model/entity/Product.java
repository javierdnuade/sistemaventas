package com.proyecto.springboot.sistema_ventas.model.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private int stock;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;

    @Column(columnDefinition = "TINYINT(1) default 1")
    private Boolean status;

}
