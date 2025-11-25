package com.proyecto.springboot.sistema_ventas.service.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.proyecto.springboot.sistema_ventas.model.dto.request.ProductRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.ProductResponseDTO;

public interface IProduct {

    List<ProductResponseDTO> getAllByCategory(int id);

    List<ProductResponseDTO> getAllByStatusActive();

    List<ProductResponseDTO> getAllByStatusDeactive();

    ProductResponseDTO save(ProductRequestDTO productRequest);

    ProductResponseDTO delete(int id);

    List<ProductResponseDTO> findAll();

    ProductResponseDTO findById(int id);

    List<ProductResponseDTO> getProductsGreaterThan(BigDecimal price);

    List<ProductResponseDTO> getProductsLessThan(BigDecimal price);
}
