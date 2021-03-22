package com.brunotarditi.proyectospringboot.controller;

import com.brunotarditi.proyectospringboot.model.Producto;
import com.brunotarditi.proyectospringboot.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/producto")
@CrossOrigin(origins = "*")
@Slf4j
public class ProductoController {

    private final ProductoService productoService;
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    //Petición get para traer todos los productos
    @GetMapping()
    public List<Producto> getAllProductos() {
        return this.productoService.findByAll();
    }

    //Petición get para traer por el id del producto
    @GetMapping(path = "/{id}")
    public Optional<Producto> getProducto(@PathVariable("id") Long id) {
        return this.productoService.findById(id);
    }

    //Petición get para traer los productos asociados al id del rubro
    @GetMapping("/id")
    public List<Producto> getIdRubro(@RequestParam("rubro") Long id) {
        return this.productoService.findByIdRubro(id);
    }

    //Petición post que me permite guardar un producto
    @PostMapping()
    public Producto saveProducto(@RequestBody Producto producto) {
        return this.productoService.save(producto);
    }

    //Petición put que me permite actualizar un producto
    @PutMapping()
    public Producto updateProducto(@RequestBody Producto producto) {
        return this.productoService.update(producto);
    }

    //Petición delete que por el id puedo borrar un producto
    @DeleteMapping(path = "/{id}")
    public void deleteProducto(@PathVariable("id") Long id) {
        this.productoService.delete(id);
    }

    //Petición get que mediante una un parametro puedo buscar por el codigo del producto
    @GetMapping(path = "/query")
    public List<Producto> findByCodigo(@RequestParam("codigo") String codigo) {
        return this.productoService.findByCodigo(codigo);
    }

}
