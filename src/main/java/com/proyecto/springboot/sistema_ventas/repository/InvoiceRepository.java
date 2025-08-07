package com.proyecto.springboot.sistema_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.springboot.sistema_ventas.model.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
