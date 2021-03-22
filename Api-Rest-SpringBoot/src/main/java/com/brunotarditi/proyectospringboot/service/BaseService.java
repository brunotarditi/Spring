package com.brunotarditi.proyectospringboot.service;


import java.util.List;
import java.util.Optional;

public interface BaseService<E> {

    /*Cada clase que implemente esta interface deberá crear las operaciones básicas del CRUD*/

    List<E> findByAll();
    Optional<E> findById(Long id);
    E save(E entidad);
    E update(E entidad);
    boolean delete(Long id);
}
