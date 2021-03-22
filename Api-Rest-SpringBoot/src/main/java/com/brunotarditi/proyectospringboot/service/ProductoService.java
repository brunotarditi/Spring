package com.brunotarditi.proyectospringboot.service;

import com.brunotarditi.proyectospringboot.model.Producto;
import com.brunotarditi.proyectospringboot.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements BaseService<Producto> {

    private final ProductoRepository productoRepository;
    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findByAll() {
        return (List<Producto>) this.productoRepository.findAll();
    }


    @Transactional(readOnly = true)
    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    @Transactional
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @Transactional
    public Producto update(Producto producto) {
        return productoRepository.save(producto);
    }

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

    @Transactional(readOnly = true)
    public List<Producto> findByIdRubro(Long id){
        return productoRepository.findByIdRubro(id);
    }

    @Transactional
    public List<Producto> findByCodigo(String codigo){
        return productoRepository.findByCodigo(codigo);
    }


}
