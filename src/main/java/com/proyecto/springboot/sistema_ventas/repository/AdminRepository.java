package com.proyecto.springboot.sistema_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.springboot.sistema_ventas.model.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
