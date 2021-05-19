package com.brunotarditi.proyectospringboot.controller;

import com.brunotarditi.proyectospringboot.model.Producto;
import com.brunotarditi.proyectospringboot.service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Se crea una clase que será el controlador de Producto para las distintas peticiones http
 * @author Bruno Tarditi
 */
@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
@Slf4j
public class ProductoController {

    private final ProductoService productoService;
    /**
     * Se pasa por parámetro un objeto de tipo ProductoService para acceder a los métodos del servicio
     * @param productoService - Objeto ProductoService
     */
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * A través de la petición get podemos realizar la petición que listará todos los productos
     */
    @GetMapping()
    public List<Producto> getAllProductos() {
        return this.productoService.findByAll();
    }

    /**
     *
     * @param id Long
     * @return A través de la petición get devuelve un Producto pasando al path la variable id del Producto
     */
    @GetMapping(path = "/{id}")
    public Optional<Producto> getProducto(@PathVariable("id") Long id) {
        return this.productoService.findById(id);
    }

    /**
     *
     * @param id Long
     * @return A través de la petición get pasando al parámetro 'id?rubro=' devuelve un Producto asociado al id del Rubro
     */
    @GetMapping("/id")
    public List<Producto> getIdRubro(@RequestParam("rubro") Long id) {
        return this.productoService.findByIdRubro(id);
    }

    /**
     *
     * @param producto Producto
     * @return A través de la petición post guarda un Producto
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping()
    public Producto saveProducto(@RequestBody Producto producto) {
        return this.productoService.save(producto);
    }

    /**
     *
     * @param producto Producto
     * @return A través de la petición put actualiza un Producto
     */
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping()
    public Producto updateProducto(@RequestBody Producto producto) {
        return this.productoService.update(producto);
    }

    /**
     *
     * @param id Long
     * A través de la petición delete, elimina un Producto pasando al path la variable id del Producto
     */
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(path = "/{id}")
    public void deleteProducto(@PathVariable("id") Long id) {
        this.productoService.delete(id);
    }

    /**
     *
     * @param codigo String
     * @return A través de la petición get pasando al parámetro 'query?codigo=' devuelve un Producto
     */
    @GetMapping(path = "/query")
    public List<Producto> findByCodigo(@RequestParam("codigo") String codigo) {
        return this.productoService.findByCodigo(codigo);
    }

}
