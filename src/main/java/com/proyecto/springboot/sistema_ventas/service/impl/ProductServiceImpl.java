package com.proyecto.springboot.sistema_ventas.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.springboot.sistema_ventas.exceptions.BadRequestException;
import com.proyecto.springboot.sistema_ventas.exceptions.ConflictException;
import com.proyecto.springboot.sistema_ventas.exceptions.NotFoundException;
import com.proyecto.springboot.sistema_ventas.model.dto.request.ProductRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.ProductResponseDTO;
import com.proyecto.springboot.sistema_ventas.model.entity.Category;
import com.proyecto.springboot.sistema_ventas.model.entity.Product;
import com.proyecto.springboot.sistema_ventas.repository.CategoryRepository;
import com.proyecto.springboot.sistema_ventas.repository.ProductRepository;
import com.proyecto.springboot.sistema_ventas.service.interfaces.IProduct;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProduct {
    
    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    @Override
    public List<ProductResponseDTO> getAllByCategory(int id) {
        // Llamamos filtrando por categoria
        List<Product> products = repository.findAllByCategory(id);
        
        // Creamos al lista de DTOs vacia
        List<ProductResponseDTO> listProductsDTO = new ArrayList<>();

        // Iteramos en cada producto y creamos con Builder y lo agregamos a la lista
        for (Product product : products) {
            ProductResponseDTO dto = ProductResponseDTO.builder()
                .name(product.getName())
                .code(product.getCode())
                .descripcion(product.getDescription())
                .stock(product.getStock())
                .price(product.getPrice())
                .categoryName(product.getCategory().getName())
                .status(product.getStatus())
            .build();
            listProductsDTO.add(dto);
        }
        return listProductsDTO;   
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductResponseDTO> getAllByStatusActive() {
        List<Product> products = repository.findAllByStatusActive();
        
        // Creamos al lista de DTOs vacia
        List<ProductResponseDTO> listProductsDTO = new ArrayList<>();

        // Iteramos en cada producto y creamos con Builder y lo agregamos a la lista
        for (Product product : products) {
            ProductResponseDTO dto = ProductResponseDTO.builder()
                .name(product.getName())
                .code(product.getCode())
                .descripcion(product.getDescription())
                .stock(product.getStock())
                .price(product.getPrice())
                .categoryName(product.getCategory().getName())
                .status(product.getStatus())
            .build();
            listProductsDTO.add(dto);
        }
        return listProductsDTO;  
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductResponseDTO> getAllByStatusDeactive() {
        List<Product> products = repository.findAllByStatusDeactivate();
        
        // Creamos al lista de DTOs vacia
        List<ProductResponseDTO> listProductsDTO = new ArrayList<>();

        // Iteramos en cada producto y creamos con Builder y lo agregamos a la lista
        for (Product product : products) {
            ProductResponseDTO dto = ProductResponseDTO.builder()
                .name(product.getName())
                .code(product.getCode())
                .descripcion(product.getDescription())
                .stock(product.getStock())
                .price(product.getPrice())
                .categoryName(product.getCategory().getName())
                .status(product.getStatus())
            .build();
            listProductsDTO.add(dto);
        }
        return listProductsDTO;
    }

    @Transactional
    @Override
    public ProductResponseDTO save(ProductRequestDTO productRequest) {
        if (productRequest == null) throw BadRequestException.invalidRequest();
        if (repository.existsByName(productRequest.getName())) throw ConflictException.productAlreadyExists(productRequest.getName());
        
        Category category = categoryRepository.findById(productRequest.getCategoryId())
            .orElseThrow(() -> NotFoundException.categoryNotFound(productRequest.getCategoryId()));


        Product product = Product.builder()
            .name(productRequest.getName())
            .code(productRequest.getCode())
            .description(productRequest.getDescription())
            .stock(productRequest.getStock())
            .price(productRequest.getPrice())
            .category(category)
            .status(productRequest.getStatus())
            .build();
        
        repository.save(product);

        return ProductResponseDTO.builder()
                .name(product.getName())
                .code(product.getCode())
                .descripcion(product.getDescription())
                .stock(product.getStock())
                .price(product.getPrice())
                .categoryName(product.getCategory().getName())
                .status(product.getStatus())
            .build();
    }

    @Transactional
    @Override
    public ProductResponseDTO delete(int id) {
        Product product = repository.findById(id)
            .orElseThrow( () -> NotFoundException.productNotFound(id));
        
        repository.deleteById(id);
        return ProductResponseDTO.builder()
            .name(product.getName())
            .code(product.getCode())
            .descripcion(product.getDescription())
            .stock(product.getStock())
            .price(product.getPrice())
            .categoryName(product.getCategory().getName())
            .status(product.getStatus())
        .build();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductResponseDTO> findAll() {
        return repository.findAll().stream().map(product ->
            ProductResponseDTO.builder()
                .name(product.getName())
                .code(product.getCode())
                .descripcion(product.getDescription())
                .stock(product.getStock())
                .price(product.getPrice())
                .categoryName(product.getCategory().getName())
                .status(product.getStatus())
            .build()
        ).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public ProductResponseDTO findById(int id) {
        Product product = repository.findById(id)
            .orElseThrow( () -> NotFoundException.productNotFound(id));
        
        return ProductResponseDTO.builder()
            .name(product.getName())
            .code(product.getCode())
            .descripcion(product.getDescription())
            .stock(product.getStock())
            .price(product.getPrice())
            .categoryName(product.getCategory().getName())
            .status(product.getStatus())
        .build();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductResponseDTO> getProductsGreaterThan(BigDecimal price) {
        List<Product> products = repository.findByPriceGreaterThan(price);
        
        // Creamos al lista de DTOs vacia
        List<ProductResponseDTO> listProductsDTO = new ArrayList<>();

        // Iteramos en cada producto y creamos con Builder y lo agregamos a la lista
        for (Product product : products) {
            ProductResponseDTO dto = ProductResponseDTO.builder()
                .name(product.getName())
                .code(product.getCode())
                .descripcion(product.getDescription())
                .stock(product.getStock())
                .price(product.getPrice())
                .categoryName(product.getCategory().getName())
                .status(product.getStatus())
            .build();
            listProductsDTO.add(dto);
        }
        return listProductsDTO;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductResponseDTO> getProductsLessThan(BigDecimal price) {
        List<Product> products = repository.findByPriceLessThan(price);
        
        // Creamos al lista de DTOs vacia
        List<ProductResponseDTO> listProductsDTO = new ArrayList<>();

        // Iteramos en cada producto y creamos con Builder y lo agregamos a la lista
        for (Product product : products) {
            ProductResponseDTO dto = ProductResponseDTO.builder()
                .name(product.getName())
                .code(product.getCode())
                .descripcion(product.getDescription())
                .stock(product.getStock())
                .price(product.getPrice())
                .categoryName(product.getCategory().getName())
                .status(product.getStatus())
            .build();
            listProductsDTO.add(dto);
        }
        return listProductsDTO;
    }

}
