package com.brunotarditi.proyectospringboot.controller;

import com.brunotarditi.proyectospringboot.model.Rubro;
import com.brunotarditi.proyectospringboot.service.RubroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rubro")
@CrossOrigin(origins = "*")
@Slf4j
public class RubroController {

    private final RubroService rubroService;

    @Autowired
    public RubroController(RubroService rubroService) {
        this.rubroService = rubroService;
    }

    //Petición get para traer todos los productos
    @GetMapping()
    public List<Rubro> getAllRubro() {
        return rubroService.findByAll();
    }

    //Petición get que me permite buscar por el id el rubro
    @GetMapping(path = "/{id}")
    public Optional<Rubro> getRubro(@PathVariable("id") Long id) {
        return rubroService.findById(id);
    }

    //Petición post que me permite guardar un rubro
    @PostMapping()
    public Rubro saveRubro(@RequestBody Rubro rubro) {
        return rubroService.save(rubro);
    }

    //Petición put que me permite actualizar un rubro
    @PutMapping()
    public Rubro updateProduct(@RequestBody Rubro rubro) {
        return this.rubroService.update(rubro);
    }

    //Petición delete que me permite eliminar un rubro por el id
    @DeleteMapping(path = "/{id}")
    public void deleteRubro(@PathVariable("id") Long id) {
        rubroService.delete(id);
    }



}
