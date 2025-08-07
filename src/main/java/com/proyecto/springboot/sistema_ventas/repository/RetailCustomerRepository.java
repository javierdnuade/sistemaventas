package com.proyecto.springboot.sistema_ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.springboot.sistema_ventas.model.entity.RetailCustomer;

public interface RetailCustomerRepository extends JpaRepository<RetailCustomer, Integer> {

}
