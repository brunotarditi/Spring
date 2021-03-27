package com.brunotarditi.proyectospringboot.service;

import com.brunotarditi.proyectospringboot.repository.RubroRepository;
import com.brunotarditi.proyectospringboot.model.Rubro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Se crea un servicio de Rubro para realizar las operaciones CRUD
 * @author Bruno Tarditi
 */
@Service
public class RubroService implements BaseService<Rubro> {

    private final RubroRepository rubroRepository;

    /**
     * Se pasa por parámetro un objeto de tipo RubroRepository para acceder a los métodos de RubroRepository
     * @param rubroRepository - Objeto RubroRepository
     */
    @Autowired
    public RubroService(RubroRepository rubroRepository) {
        this.rubroRepository = rubroRepository;
    }

    /**
     *
     * @return Devuelve el listado completo de la entidad Rubro
     */
    @Override
    @Transactional(readOnly = true)
    public List<Rubro> findByAll() {
        return (List<Rubro>) rubroRepository.findAll();
    }
    /**
     *
     * @param id Long
     * @return Devuelve una entidad Rubro a través del identificador que se pase como parámetro
     */
    @Transactional(readOnly = true)
    @Override
    public Optional<Rubro> findById(Long id) {
        return rubroRepository.findById(id);
    }
    /**
     *
     * @param rubro Rubro
     * @return Guarda una entidad Rubro pasando la entidad como parámetro
     */
    @Override
    @Transactional
    public Rubro save(Rubro rubro) {
        return rubroRepository.save(rubro);
    }

    /**
     *
     * @param rubro Rubro
     * @return Actualiza una entidad Rubro pasando la entidad como parámetro
     */
    @Override
    @Transactional
    public Rubro update(Rubro rubro) {
        return rubroRepository.save(rubro);
    }

    /**
     *
     * @param id Long
     * @return Elimina una entidad Rubro a través de su identificador que se pase como parámetro
     */
    @Override
    @Transactional
    public boolean delete(Long id) {
        try {
            rubroRepository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
