package com.aortiz.ventas.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "DETALLE_VENTA")
public class DetalleVenta  implements Serializable{
    @EmbeddedId
    DetalleVentaKey id;

    @ManyToOne()
    @MapsId("idVenta")
    @JsonIgnoreProperties("detalle")
    @JoinColumn(name = "IDE_VEN")
    Venta venta;

    @ManyToOne()
    @MapsId("idProducto")
    @JsonIgnoreProperties("detalle")
    @JoinColumn(name = "IDE_PRO")
    Producto producto;

    @Column(name = "PRE_DET")
    double precio;

    @Column(name = "CAN_DET")
    int cantidad;
}
