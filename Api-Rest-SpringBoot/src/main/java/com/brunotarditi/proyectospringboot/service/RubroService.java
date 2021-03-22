package com.brunotarditi.proyectospringboot.service;

import com.brunotarditi.proyectospringboot.repository.RubroRepository;
import com.brunotarditi.proyectospringboot.model.Rubro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RubroService implements BaseService<Rubro> {

    private final RubroRepository rubroRepository;

    @Autowired
    public RubroService(RubroRepository rubroRepository) {
        this.rubroRepository = rubroRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Rubro> findByAll() {
        return (List<Rubro>) rubroRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Rubro> findById(Long id) {
        return rubroRepository.findById(id);
    }

    @Override
    @Transactional
    public Rubro save(Rubro rubro) {
        return rubroRepository.save(rubro);
    }

    @Override
    @Transactional
    public Rubro update(Rubro entidad) {
        return rubroRepository.save(entidad);
    }

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
