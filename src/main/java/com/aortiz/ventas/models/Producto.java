package com.aortiz.ventas.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "PRODUCTO")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDE_PRO")
    private Long id;

    @Column(name = "DSC_PRO")
    @NotEmpty
    private String descripcion;

    @Column(name = "STK_PRO")
    @NotEmpty
    private int stock;

    @Column(name = "PRE_PRO")
    @NotEmpty
    private double precio;

    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detalle;
}
