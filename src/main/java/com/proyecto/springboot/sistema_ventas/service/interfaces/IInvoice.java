package com.proyecto.springboot.sistema_ventas.service.interfaces;

import java.util.List;

import com.proyecto.springboot.sistema_ventas.model.dto.request.InvoiceRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.InvoiceResponseDTO;

public interface IInvoice {

    InvoiceResponseDTO create(int customerId, InvoiceRequestDTO invoiceRequest);

    List<InvoiceResponseDTO> findAll();

    InvoiceResponseDTO findById(int id);

    InvoiceResponseDTO delete(int id);

    List<InvoiceResponseDTO> getInvoicesByCustomer(int id);
}
