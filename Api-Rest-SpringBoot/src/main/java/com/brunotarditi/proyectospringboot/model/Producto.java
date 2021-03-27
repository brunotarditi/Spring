package com.brunotarditi.proyectospringboot.model;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Clase Producto es la que almacenará cada producto relacionado a un Rubro
 * @author Bruno Tarditi
 */

@Data
@Entity
@Table(name = "producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "denominacion")
    private String denominacion;

    @Column(name = "precio")
    private double precio;
    // relacion muchos productos a un rubro.fk = id_rubro
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_rubro")
    private Rubro rubro;
}
