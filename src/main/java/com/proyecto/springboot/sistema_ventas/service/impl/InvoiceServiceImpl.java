package com.proyecto.springboot.sistema_ventas.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.springboot.sistema_ventas.exceptions.ConflictException;
import com.proyecto.springboot.sistema_ventas.exceptions.NotFoundException;
import com.proyecto.springboot.sistema_ventas.model.dto.request.InvoiceDetailRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.request.InvoiceRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.InvoiceDetailResponseDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.InvoiceResponseDTO;
import com.proyecto.springboot.sistema_ventas.model.entity.Customer;
import com.proyecto.springboot.sistema_ventas.model.entity.Invoice;
import com.proyecto.springboot.sistema_ventas.model.entity.InvoiceDetail;
import com.proyecto.springboot.sistema_ventas.model.entity.Product;
import com.proyecto.springboot.sistema_ventas.repository.InvoiceRepository;
import com.proyecto.springboot.sistema_ventas.repository.ProductRepository;
import com.proyecto.springboot.sistema_ventas.repository.RetailCustomerRepository;
import com.proyecto.springboot.sistema_ventas.repository.WholesaleCustomerRepository;
import com.proyecto.springboot.sistema_ventas.service.interfaces.IInvoice;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvoiceServiceImpl implements IInvoice {

    private final InvoiceRepository repository;
    private final ProductRepository productRepository;
    private final WholesaleCustomerRepository wholesaleRepository;
    private final RetailCustomerRepository retailRepository;

    @Transactional
    @Override
    public InvoiceResponseDTO create(int customerId, InvoiceRequestDTO invoiceRequest) {
        Optional<Customer> customerOpt = retailRepository.findById(customerId).map(c -> (Customer) c);
        if (customerOpt.isEmpty()) {
            customerOpt = wholesaleRepository.findById(customerId).map(c -> (Customer) c);
        }

        if (customerOpt.isEmpty()) {
            throw NotFoundException.userNotFound(customerId);
        }

        // Si existe el cliente, hacemos el get
        Customer customer = customerOpt.get();

        Invoice invoice = new Invoice();
        invoice.setCustomer(customer);
        invoice.setDate(LocalDateTime.now());
        List<InvoiceDetail> details = new ArrayList<>();

        BigDecimal total = BigDecimal.ZERO;

        for (InvoiceDetailRequestDTO item : invoiceRequest.getItems()) {
            Product product = productRepository.findById(item.getProductId())
                .orElseThrow(() -> NotFoundException.productNotFound(item.getProductId()));

            if (product.getStock() < item.getQuantity()) throw ConflictException.productNoStock(product.getName());

            InvoiceDetail detail = InvoiceDetail.builder()
                .product(product)
                .invoice(invoice)
                .quantity(item.getQuantity())
                .line_total(product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .build();

            product.restarStock(item.getQuantity()); // Restamos stock al producto
            total = total.add(detail.getLine_total()); // Sumamos el total de la linea a la factura
            details.add(detail);
        }

        invoice.setInvoiceDetails(details);
        invoice.setTotal(total);
        Invoice saved = repository.save(invoice);

        // Usamos saved ya que tiene el ID generado
        InvoiceResponseDTO dto = new InvoiceResponseDTO();
        dto.setId(saved.getId());
        dto.setDate(saved.getDate());
        dto.setCustomerId(saved.getCustomer().getId());
        dto.setCustomerUsername(saved.getCustomer().getUsername());
        dto.setTotal(saved.getTotal());

        List<InvoiceDetailResponseDTO> dtoDetail = new ArrayList<>();
        for (InvoiceDetail detail : details) { // Convertimos los detalles a DTO
            InvoiceDetailResponseDTO detailDTO = InvoiceDetailResponseDTO.builder()
                .productName(detail.getProduct().getName())
                .quantity(detail.getQuantity())
                .line_total(detail.getLine_total())
                .build();
            dtoDetail.add(detailDTO);
        }
    
        return dto;
    }

    @Transactional(readOnly = true)
    @Override
    public List<InvoiceResponseDTO> findAll() {

        List<Invoice> invoices = repository.findAllWithDetails();
        List<InvoiceResponseDTO> invoiceDTOs = new ArrayList<>();

        for (Invoice invoice : invoices) {

            InvoiceResponseDTO dto = new InvoiceResponseDTO();
            dto.setId(invoice.getId());
            dto.setDate(invoice.getDate());
            dto.setCustomerId(invoice.getCustomer().getId());
            dto.setCustomerUsername(invoice.getCustomer().getUsername());
            dto.setTotal(invoice.getTotal());

            List<InvoiceDetailResponseDTO> dtoDetail = new ArrayList<>();

            for (InvoiceDetail detail : invoice.getInvoiceDetails()) {
                InvoiceDetailResponseDTO detailDTO = InvoiceDetailResponseDTO.builder()
                    .productName(detail.getProduct().getName())
                    .quantity(detail.getQuantity())
                    .line_total(detail.getLine_total())
                    .build();

                dtoDetail.add(detailDTO);
            }
            dto.setInvoiceDetails(dtoDetail);
            invoiceDTOs.add(dto);
        }
        return invoiceDTOs;
    }

    @Transactional(readOnly = true)
    @Override
    public InvoiceResponseDTO findById(int id) {
        Invoice invoice = repository.findById(id)
            .orElseThrow( () -> NotFoundException.invoiceNotFound(id));
        
        InvoiceResponseDTO dto = new InvoiceResponseDTO();
        List<InvoiceDetailResponseDTO> dtoDetail = new ArrayList<>();

        dto.setId(invoice.getId());
        dto.setDate(invoice.getDate());
        dto.setCustomerId(invoice.getCustomer().getId());
        dto.setCustomerUsername(invoice.getCustomer().getUsername());
        dto.setTotal(invoice.getTotal());
        for (InvoiceDetail detail : invoice.getInvoiceDetails()) {
        InvoiceDetailResponseDTO detailDTO = InvoiceDetailResponseDTO.builder()
            .productName(detail.getProduct().getName())
            .quantity(detail.getQuantity())
            .line_total(detail.getLine_total())
            .build();
        dtoDetail.add(detailDTO); // Agregamos cada detalle a la lista de detalles
        }
        dto.setInvoiceDetails(dtoDetail); // Seteamos en el DTO la lista de detalles
        return dto;
    }

    @Transactional
    @Override
    public InvoiceResponseDTO delete(int id) {
        Invoice invoice = repository.findById(id)
            .orElseThrow( () -> NotFoundException.invoiceNotFound(id));

        InvoiceResponseDTO dto = new InvoiceResponseDTO();
        List<InvoiceDetailResponseDTO> dtoDetail = new ArrayList<>();

        dto.setId(invoice.getId());
        dto.setDate(invoice.getDate());
        dto.setCustomerId(invoice.getCustomer().getId());
        dto.setCustomerUsername(invoice.getCustomer().getUsername());
        dto.setTotal(invoice.getTotal());
        for (InvoiceDetail detail : invoice.getInvoiceDetails()) {
        InvoiceDetailResponseDTO detailDTO = InvoiceDetailResponseDTO.builder()
            .productName(detail.getProduct().getName())
            .quantity(detail.getQuantity())
            .line_total(detail.getLine_total())
            .build();
        dtoDetail.add(detailDTO); // Agregamos cada detalle a la lista de detalles
        }
        dto.setInvoiceDetails(dtoDetail);

        repository.delete(invoice);
        return dto;

    }

    @Transactional(readOnly = true)
    @Override
    public List<InvoiceResponseDTO> getInvoicesByCustomer(int id) {
        
        List<Invoice> invoices = repository.findAllByCustomer(id);

        List<InvoiceResponseDTO> invoiceDTOs = new ArrayList<>();

        for (Invoice invoice : invoices) {
            InvoiceResponseDTO dto = new InvoiceResponseDTO();

            dto.setId(invoice.getId());
            dto.setDate(invoice.getDate());
            dto.setCustomerId(invoice.getCustomer().getId());
            dto.setCustomerUsername(invoice.getCustomer().getUsername());
            dto.setTotal(invoice.getTotal());

            List<InvoiceDetailResponseDTO> details = new ArrayList<>();

            for (InvoiceDetail detail : invoice.getInvoiceDetails()) {
                InvoiceDetailResponseDTO dDTO = InvoiceDetailResponseDTO.builder()
                        .productName(detail.getProduct().getName())
                        .quantity(detail.getQuantity())
                        .line_total(detail.getLine_total())
                        .build();

                details.add(dDTO);
            }

            dto.setInvoiceDetails(details);
            invoiceDTOs.add(dto);
        }

        return invoiceDTOs;
    }
}
