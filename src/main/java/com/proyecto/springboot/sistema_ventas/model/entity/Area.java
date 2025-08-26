package com.proyecto.springboot.sistema_ventas.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "areas")
@Data
public class Area {

    @Id
    private int id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "area")
    private List<WholesaleCustomer> wholesales;
}
