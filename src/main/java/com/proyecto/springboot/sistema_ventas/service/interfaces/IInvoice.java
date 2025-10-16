package com.proyecto.springboot.sistema_ventas.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.proyecto.springboot.sistema_ventas.model.dto.request.InvoiceDetailRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.InvoiceResponseDTO;

public interface IInvoice {

    InvoiceResponseDTO create(List<InvoiceDetailRequestDTO> invoiceDetail);

    List<InvoiceResponseDTO> findAll();

    Optional<InvoiceResponseDTO> findById(int id);

    Optional<InvoiceResponseDTO> delete(int id);

    List<InvoiceResponseDTO> getInvoicesByCustomer(int id);
}
