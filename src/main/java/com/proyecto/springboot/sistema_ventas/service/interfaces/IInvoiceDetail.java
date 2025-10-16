package com.proyecto.springboot.sistema_ventas.service.interfaces;

import com.proyecto.springboot.sistema_ventas.model.dto.request.InvoiceDetailRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.InvoiceDetailResponseDTO;

public interface IInvoiceDetail {
    InvoiceDetailResponseDTO addInvoiceDetail(InvoiceDetailRequestDTO detail);

}
