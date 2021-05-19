package com.brunotarditi.proyectospringboot.security.service;

import com.brunotarditi.proyectospringboot.security.entity.Rol;
import com.brunotarditi.proyectospringboot.security.enums.RolNombre;
import com.brunotarditi.proyectospringboot.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    private final RolRepository repository;

    @Autowired
    public RolService(RolRepository repository) {
        this.repository = repository;
    }

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return this.repository.findByRolNombre(rolNombre);
    }

}
