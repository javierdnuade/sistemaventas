package com.proyecto.springboot.sistema_ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.springboot.sistema_ventas.model.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

    @Query("""
        SELECT DISTINCT i
        FROM Invoice i
        LEFT JOIN FETCH i.customer
        LEFT JOIN FETCH i.invoiceDetails d
        LEFT JOIN FETCH d.product
        """)
    List<Invoice> findAllWithDetails(); // Consulta para evitar cargas Lazy al llamar todas las facturas

    @Query("""
        SELECT DISTINCT i FROM Invoice i
        JOIN FETCH i.customer c
        JOIN FETCH i.invoiceDetails d
        JOIN FETCH d.product p
        WHERE c.id = :customerId
        """)
    List<Invoice> findAllByCustomer(@Param("customerId") Integer customerId);
}
