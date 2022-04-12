package com.aortiz.ventas.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class DetalleVentaKey implements Serializable {

    @Column(name = "IDE_VEN")
    Long idVenta;

    @Column(name = "IDE_PRO")
    Long idProducto;
}