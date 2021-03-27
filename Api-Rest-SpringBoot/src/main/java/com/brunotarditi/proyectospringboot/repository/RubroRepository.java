package com.brunotarditi.proyectospringboot.repository;

import com.brunotarditi.proyectospringboot.model.Rubro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface RubroRepository que extiende de la interface CrudRepository
 * @author Bruno Tarditi
 */
@Repository
public interface RubroRepository extends CrudRepository<Rubro, Long> {
}
