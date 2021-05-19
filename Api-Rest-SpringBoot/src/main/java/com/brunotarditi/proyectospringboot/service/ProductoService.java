package com.brunotarditi.proyectospringboot.service;

import com.brunotarditi.proyectospringboot.model.Producto;
import com.brunotarditi.proyectospringboot.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Se crea un servicio de Producto para realizar las operaciones CRUD
 * @author Bruno Tarditi
 */
@Service
public class ProductoService implements BaseService<Producto> {

    private final ProductoRepository productoRepository;

    /**
     * Se pasa por parámetro un objeto de tipo ProductoRepository para acceder a los métodos de ProductoRepository
     * @param productoRepository - Objeto ProductoRepository
     */
    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    /**
     *
     * @return Devuelve el listado completo de la entidad Producto
     */
    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByAll() {
        return (List<Producto>) this.productoRepository.findAll();
    }

    /**
     *
     * @param id Long
     * @return Devuelve una entidad Producto a través del identificador que se pase como parámetro
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    /**
     *
     * @param producto Producto
     * @return Guarda una entidad Producto pasando la entidad como parámetro
     */
    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    /**
     *
     * @param producto Producto
     * @return Actualiza una entidad Producto pasando la entidad como parámetro
     */

    @Override
    @Transactional
    public Producto update(Producto producto) {
        return productoRepository.save(producto);
    }

    /**
     *
     * @param id Long
     * @return Elimina una entidad Producto a través de su identificador que se pase como parámetro
     */
    @Override
    @Transactional
    public boolean delete(Long id) {
        try {
            productoRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     *
     * @param id Long
     * @return Devuelve un listado de la entidad Producto pero a través de la clave foránea relacionada a Rubro
     */
    @Transactional(readOnly = true)
    public List<Producto> findByIdRubro(Long id){
        return productoRepository.findByIdRubro(id);
    }

    /**
     *
     * @param codigo String
     * @return Devuelve un listado de la entidad Producto a través de un código que se pase como parámetro
     */
    @Transactional
    public List<Producto> findByCodigo(String codigo){
        return productoRepository.findByCodigo(codigo);
    }

}
