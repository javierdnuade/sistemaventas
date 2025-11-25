package com.proyecto.springboot.sistema_ventas.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.springboot.sistema_ventas.exceptions.BadRequestException;
import com.proyecto.springboot.sistema_ventas.exceptions.ConflictException;
import com.proyecto.springboot.sistema_ventas.exceptions.NotFoundException;
import com.proyecto.springboot.sistema_ventas.model.dto.request.RetailCustomerRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.RetailCustomerResponseDTO;
import com.proyecto.springboot.sistema_ventas.model.entity.RetailCustomer;
import com.proyecto.springboot.sistema_ventas.model.entity.Role;
import com.proyecto.springboot.sistema_ventas.repository.RetailCustomerRepository;
import com.proyecto.springboot.sistema_ventas.repository.RoleRepository;
import com.proyecto.springboot.sistema_ventas.service.interfaces.IRetailCustomer;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RetailCustomerServiceImpl implements IRetailCustomer {

    private final RetailCustomerRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Transactional
    @Override
    public RetailCustomerResponseDTO save(RetailCustomerRequestDTO req) {
        if (req == null ) throw BadRequestException.invalidRequest();
        if (repository.existsByUsername(req.getUsername()) || repository.existsByEmail(req.getEmail())) {
            throw ConflictException.userAlreadyExists(); // Arrojamos error personalizado de Conflict por usuario existente
        }

        Set<Role> roles = new HashSet<>();
        roleRepository.findByName("ROLE_RETAIL").ifPresent(roles::add);

        String encodedPasword = passwordEncoder.encode(req.getPassword());
        RetailCustomer retail = RetailCustomer.builder()
            .username(req.getUsername())
            .email(req.getEmail())
            .password(encodedPasword)
            .roles(roles)
            .name(req.getName())
            .phone(req.getPhone())
            .dni(req.getDni())
            .build();
        
        repository.save(retail);
        return RetailCustomerResponseDTO.builder()
            .username(retail.getUsername())
            .email(retail.getEmail())
            .name(retail.getName())
            .phone(retail.getPhone())
            .build();

    }

    @Transactional
    @Override
    public RetailCustomerResponseDTO delete(int id) {
        RetailCustomer retail = repository.findById(id)
            .orElseThrow( () -> NotFoundException.userNotFound(id));

        repository.deleteById(id);
        return RetailCustomerResponseDTO.builder()
            .username(retail.getUsername())
            .email(retail.getEmail())
            .name(retail.getName())
            .phone(retail.getPhone())
            .build();   
        }

    @Transactional(readOnly = true)
    @Override
    public List<RetailCustomerResponseDTO> findAll() {
        return repository.findAll().stream().map(retail -> 
            RetailCustomerResponseDTO.builder()
            .username(retail.getUsername())
            .email(retail.getEmail())
            .name(retail.getName())
            .phone(retail.getPhone())
            .build()  
        ).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public RetailCustomerResponseDTO findById(int id) {
        RetailCustomer retail = repository.findById(id)
            .orElseThrow( () -> NotFoundException.userNotFound(id));

        return RetailCustomerResponseDTO.builder()
            .username(retail.getUsername())
            .email(retail.getEmail())
            .name(retail.getName())
            .phone(retail.getPhone())
            .build(); 
    }
}
