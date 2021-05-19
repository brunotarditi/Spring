package com.brunotarditi.proyectospringboot.controller;

import com.brunotarditi.proyectospringboot.model.Rubro;
import com.brunotarditi.proyectospringboot.service.RubroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


/**
 * Se crea una clase que será el controlador de Rubro para las distintas peticiones http
 * @author Bruno Tarditi
 */
@RestController
@RequestMapping("/rubros")
@CrossOrigin(origins = "*")
@Slf4j
public class RubroController {

    private final RubroService rubroService;

    /**
     * Se pasa por parámetro un objeto de tipo RubroService para acceder a los métodos del servicio
     * @param rubroService - Objeto RubroService
     */
    @Autowired
    public RubroController(RubroService rubroService) {
        this.rubroService = rubroService;
    }

    /**
     * A través de la petición get podemos realizar la petición que listará todos los rubros
     */
    @GetMapping()
    public List<Rubro> getAllRubro() {
        return rubroService.findByAll();
    }

    /**
     *
     * @param id Long
     * @return A través de la petición get devuelve un Rubro pasando al path la variable id del Rubro
     */
    @GetMapping(path = "/{id}")
    public Optional<Rubro> getRubro(@PathVariable("id") Long id) {
        return rubroService.findById(id);
    }

    /**
     *
     * @param rubro Rubro
     * @return A través de la petición post guarda un Rubro
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public Rubro saveRubro(@RequestBody Rubro rubro) {
        return rubroService.save(rubro);
    }

    /**
     *
     * @param rubro Rubro
     * @return A través de la petición put actualiza un Rubro
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping()
    public Rubro updateProduct(@RequestBody Rubro rubro) {
        return this.rubroService.update(rubro);
    }

    /**
     *
     * @param id Long
     * A través de la petición delete, elimina un Rubro pasando al path la variable id del Rubro
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public void deleteRubro(@PathVariable("id") Long id) {
        rubroService.delete(id);
    }

}
