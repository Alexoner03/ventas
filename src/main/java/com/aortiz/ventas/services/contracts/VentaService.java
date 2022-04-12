package com.aortiz.ventas.services.contracts;

import com.aortiz.ventas.models.DetalleVenta;
import com.aortiz.ventas.models.Venta;

import java.util.List;

public interface VentaService {

    List<Venta> listar();

    void guardar(Venta venta);

    List<DetalleVenta> detalleById(Long id);

}
