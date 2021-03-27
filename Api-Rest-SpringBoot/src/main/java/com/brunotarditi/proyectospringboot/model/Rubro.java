package com.brunotarditi.proyectospringboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

/**
 * Clase Rubro es la que almacenará cada rubro y este contendrá muchos productos
 * @author Bruno Tarditi
 */
@Data
@Entity
@Table(name = "rubro")
public class Rubro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column(name = "denominacion")
    private String denominacion;

    // relacion de un rubro a muchos productos de pk.id = rubro
    @JsonIgnore
    @OneToMany(mappedBy = "rubro", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Producto> productos;

}
