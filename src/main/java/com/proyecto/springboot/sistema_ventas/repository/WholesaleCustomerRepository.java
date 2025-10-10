package com.proyecto.springboot.sistema_ventas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.springboot.sistema_ventas.model.entity.WholesaleCustomer;

public interface WholesaleCustomerRepository extends JpaRepository<WholesaleCustomer, Integer>  {

    List<WholesaleCustomer> findAllByArea(int id);
}
