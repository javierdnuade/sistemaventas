package com.proyecto.springboot.sistema_ventas.service.interfaces;

import java.util.List;

import com.proyecto.springboot.sistema_ventas.model.dto.response.WholesaleCustomerResponseDTO;

public interface IWholesaleCustomer {

    List<WholesaleCustomerResponseDTO> getAllByArea(int id);
}
