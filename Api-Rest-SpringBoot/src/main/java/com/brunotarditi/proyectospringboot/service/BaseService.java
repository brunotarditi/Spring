package com.brunotarditi.proyectospringboot.service;

import java.util.List;
import java.util.Optional;

/**
 * BaseService es una interface en la que espera una Entidad e implementa métodos genéricos para un CRUD
 * @author Bruno Tarditi
 * @param <E> Entidad
 */

public interface BaseService<E> {

    List<E> findByAll();
    Optional<E> findById(Long id);
    E save(E entidad);
    E update(E entidad);
    boolean delete(Long id);
}
