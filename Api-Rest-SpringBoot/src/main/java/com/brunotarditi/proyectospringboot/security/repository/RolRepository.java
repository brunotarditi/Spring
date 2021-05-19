package com.brunotarditi.proyectospringboot.security.repository;

import com.brunotarditi.proyectospringboot.security.entity.Rol;
import com.brunotarditi.proyectospringboot.security.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
