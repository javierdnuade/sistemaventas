package com.proyecto.springboot.sistema_ventas.service.interfaces;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.proyecto.springboot.sistema_ventas.model.dto.request.ProductRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.ProductResponseDTO;

public interface IProduct {

    List<ProductResponseDTO> getAllByCategory(int id);

    List<ProductResponseDTO> getAllByStatus(boolean status);

    ProductResponseDTO save(ProductRequestDTO productRequest);

    Optional<ProductResponseDTO> delete(int id);

    List<ProductResponseDTO> findAll();

    Optional<ProductResponseDTO> findById(int id);

    List<ProductResponseDTO> getProductsGreaterThan(BigDecimal price);

    List<ProductResponseDTO> getProductsLessThan(BigDecimal price);
}
