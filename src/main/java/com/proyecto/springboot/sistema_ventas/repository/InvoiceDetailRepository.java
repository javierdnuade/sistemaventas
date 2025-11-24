package com.proyecto.springboot.sistema_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.springboot.sistema_ventas.model.entity.InvoiceDetail;
import com.proyecto.springboot.sistema_ventas.model.entity.embeddable.InvoiceDetailID;

public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, InvoiceDetailID>{

}
