package com.proyecto.springboot.sistema_ventas.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.springboot.sistema_ventas.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    List<Product> findAllByCategory(int id);

    List<Product> findAllByStatus(boolean status);

    // Productos con precio mayor a un valor dado
    List<Product> findByPriceGreaterThan(BigDecimal price);

    // Productos con precio menor a un valor dado
    List<Product> findByPriceLessThan(BigDecimal price);

}
