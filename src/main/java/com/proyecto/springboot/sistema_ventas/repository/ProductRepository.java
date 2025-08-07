package com.proyecto.springboot.sistema_ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.springboot.sistema_ventas.model.entity.Category;
import com.proyecto.springboot.sistema_ventas.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    List<Product> findAllByCategory(Category category);

    List<Product> findAllByStatus(boolean status);

}
