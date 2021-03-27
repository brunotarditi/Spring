package com.brunotarditi.proyectospringboot.repository;

import com.brunotarditi.proyectospringboot.model.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface ProductoRepository que extiende de la interface CrudRepository
 * @author Bruno Tarditi
 */
@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    /**
     * Se utiliza JPQL para realizar una consulta personalizada
     *
     * @param idRubro - Long
     * @return Devuelve una lista de productos que se encuentran por el id del Rubro que se pase por parámetro.
     */
    @Query(value = "SELECT p FROM Producto p WHERE p.rubro.id = :idRubro")
    List<Producto> findByIdRubro(@Param("idRubro") Long idRubro);

    /**
     * @param codigo - String
     * @return Devuelve una lista de productos que se encuentran por el código que se pase por parámetro
     */
    List<Producto> findByCodigo(String codigo);
}
