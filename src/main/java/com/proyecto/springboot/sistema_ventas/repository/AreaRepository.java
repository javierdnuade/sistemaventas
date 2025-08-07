package com.proyecto.springboot.sistema_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.springboot.sistema_ventas.model.entity.Area;

public interface AreaRepository extends JpaRepository<Area, Integer> {

}
