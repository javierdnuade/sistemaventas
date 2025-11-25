package com.proyecto.springboot.sistema_ventas.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.springboot.sistema_ventas.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

    @Query("""
        SELECT p FROM Product p
        JOIN FETCH p.category c
        WHERE c.id = :categoryId
        """)    
    List<Product> findAllByCategory(@Param("categoryId") int categoryId);

    @Query("""
        SELECT p FROM Product p
        JOIN FETCH p.category c
        WHERE p.status = true
        """)    
    List<Product> findAllByStatusActive();

    @Query("""
        SELECT p FROM Product p
        JOIN FETCH p.category c
        WHERE p.status = false
        """)    
    List<Product> findAllByStatusDeactivate();

    // Productos con precio mayor a un valor dado
    @Query("""
        SELECT p FROM Product p
        JOIN FETCH p.category c
        WHERE c.price > :priceGreater
        """)
    List<Product> findByPriceGreaterThan(@Param("priceGreater") BigDecimal priceGreater);

    // Productos con precio menor a un valor dado
    @Query("""
        SELECT p FROM Product p
        JOIN FETCH p.category c
        WHERE c.price < :priceGreater
        """)
    List<Product> findByPriceLessThan(BigDecimal price);

    boolean existsByName(String name);
}
