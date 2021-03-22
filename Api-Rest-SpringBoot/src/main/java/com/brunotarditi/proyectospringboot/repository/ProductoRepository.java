package com.brunotarditi.proyectospringboot.repository;

import com.brunotarditi.proyectospringboot.model.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    @Query(value = "SELECT p FROM Producto p WHERE p.rubro.id = :idRubro") //JPQL
    List<Producto> findByIdRubro(@Param("idRubro") Long idRubro);

    List<Producto> findByCodigo(String codigo); //Metodo personalizado para buscar por código

}
