package com.proyecto.springboot.sistema_ventas.service.interfaces;

import java.util.List;

import com.proyecto.springboot.sistema_ventas.model.dto.request.RetailCustomerRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.RetailCustomerResponseDTO;

public interface IRetailCustomer {

    RetailCustomerResponseDTO save(RetailCustomerRequestDTO retailRequest);

    RetailCustomerResponseDTO delete(int id);

    List<RetailCustomerResponseDTO> findAll();

    RetailCustomerResponseDTO findById(int id);
}
