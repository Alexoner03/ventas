package com.aortiz.ventas.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "VENTA")
public class Venta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDE_VEN")
    private Long id;

    @NotEmpty
    @Column(name = "TOT_VEN")
    private int total;

    @NotEmpty
    @Column(name = "FEC_VEN")
    private Date fecha;

    @NotEmpty
    @Column(name = "NOM_CLI")
    private String nombreCliente;

    @ManyToOne
    @JoinColumn(name="IDE_USR")
    private Usuario usuario;

    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detalle;
}
