package com.proyecto.springboot.sistema_ventas.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    private int id;
    
    @Column(unique = true)
    private String name;

    // Direcion ManyToMany con tabla intermedia "users_roles", ya que un usuario puede tener muchos roles, y muchos roles 1 usuario
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
