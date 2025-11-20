package com.proyecto.springboot.sistema_ventas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.proyecto.springboot.sistema_ventas.model.dto.request.InvoiceDetailRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.InvoiceResponseDTO;
import com.proyecto.springboot.sistema_ventas.repository.InvoiceRepository;
import com.proyecto.springboot.sistema_ventas.service.interfaces.IInvoice;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements IInvoice {

    private final InvoiceRepository repository;

    @Override
    public InvoiceResponseDTO create(List<InvoiceDetailRequestDTO> invoiceDetail) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public List<InvoiceResponseDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<InvoiceResponseDTO> findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Optional<InvoiceResponseDTO> delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<InvoiceResponseDTO> getInvoicesByCustomer(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getInvoicesByCustomer'");
    }

}
