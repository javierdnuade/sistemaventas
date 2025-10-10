package com.proyecto.springboot.sistema_ventas.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.springboot.sistema_ventas.model.dto.request.WholesaleCustomerRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.WholesaleCustomerResponseDTO;

public interface IWholesaleCustomer {

    WholesaleCustomerResponseDTO save (WholesaleCustomerRequestDTO wholesaleRequest);

    Optional<WholesaleCustomerResponseDTO> delete (int id);

    List<WholesaleCustomerResponseDTO> findAll();

    Optional<WholesaleCustomerResponseDTO> findById(int id);

    List<WholesaleCustomerResponseDTO> getAllByArea(int id);
}
