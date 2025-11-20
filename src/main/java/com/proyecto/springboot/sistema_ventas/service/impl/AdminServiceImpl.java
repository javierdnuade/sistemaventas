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
import com.proyecto.springboot.sistema_ventas.model.dto.request.AdminRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.AdminResponseDTO;
import com.proyecto.springboot.sistema_ventas.model.entity.Admin;
import com.proyecto.springboot.sistema_ventas.model.entity.Role;
import com.proyecto.springboot.sistema_ventas.repository.AdminRepository;
import com.proyecto.springboot.sistema_ventas.repository.RoleRepository;
import com.proyecto.springboot.sistema_ventas.service.interfaces.IAdminService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements IAdminService {

    private final AdminRepository repository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public AdminResponseDTO save(AdminRequestDTO adminRequest) {
        if (adminRequest == null) {
            throw BadRequestException.invalidRequest(); // Arrojamos error personalizado de BadRequest
        }
        if (repository.existsByUsername(adminRequest.getUsername()) || repository.existsByEmail(adminRequest.getEmail())) {
            throw ConflictException.userAlreadyExists(); // Arrojamos error personalizado de Conflict por usuario existente
        }

        // Agregamos todos los roles al admin
        Set<Role> roles = new HashSet<>();
        roleRepository.findByName("ROLE_ADMIN").ifPresent(roles::add);
        roleRepository.findByName("ROLE_RETAIL").ifPresent(roles::add);
        roleRepository.findByName("ROLE_WHOLESALE").ifPresent(roles::add);

        // Codificamos la password
        String encodedPassword = passwordEncoder.encode(adminRequest.getPassword());
        
        Admin admin = Admin.builder()
            .username(adminRequest.getUsername())
            .email(adminRequest.getEmail())
            .password(encodedPassword)
            .roles(roles)
            .build();

        repository.save(admin);
        return AdminResponseDTO.builder()
            .username(admin.getUsername())
            .email(admin.getEmail())
            .userType("ADMIN")
            .build();
    }

    @Transactional
    @Override
    public AdminResponseDTO delete(int id) {
        Admin admin = repository.findById(id)
            .orElseThrow(() -> NotFoundException.userNotFound(id));
        
        repository.deleteById(id); // Lo borramos de la base (pero sigue en memoria porque JPA trabaja sobre la base)
        return AdminResponseDTO.builder() // Como todavia existe en memoria, llamamos a sus datos
                .username(admin.getUsername())
                .email(admin.getEmail())
                .userType("ADMIN")
                .build();

    }

    @Transactional(readOnly = true)
    @Override
    public AdminResponseDTO findById(int id) {
        Admin admin = repository.findById(id)
            .orElseThrow( () -> NotFoundException.userNotFound(id));
        
        return AdminResponseDTO.builder() // Como todavia existe en memoria, llamamos a sus datos
                .username(admin.getUsername())
                .email(admin.getEmail())
                .userType("ADMIN")
                .build();
    }

    @Transactional(readOnly = true)
    @Override
    public List<AdminResponseDTO> findAll() {
        return repository.findAll().stream().map(admin -> 
            AdminResponseDTO.builder()
                .username(admin.getUsername())
                .email(admin.getEmail())
                .userType("ADMIN")
                .build()
        )
        .collect(Collectors.toList());
    }

}
