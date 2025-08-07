package com.proyecto.springboot.sistema_ventas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.springboot.sistema_ventas.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Boolean existsByName(String name);

    Optional<Role> findByName(String name);

}
