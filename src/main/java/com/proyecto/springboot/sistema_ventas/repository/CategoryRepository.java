package com.proyecto.springboot.sistema_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.springboot.sistema_ventas.model.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

    boolean existsByName(String name);
}
