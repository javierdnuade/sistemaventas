package com.proyecto.springboot.sistema_ventas.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.springboot.sistema_ventas.model.dto.request.RetailCustomerRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.RetailCustomerResponseDTO;

public interface IRetailCustomer {

    RetailCustomerResponseDTO save(RetailCustomerRequestDTO retailRequest);

    Optional<RetailCustomerResponseDTO> delete(int id);

    List<RetailCustomerResponseDTO> findAll();

    Optional<RetailCustomerResponseDTO> findById(int id);
}
