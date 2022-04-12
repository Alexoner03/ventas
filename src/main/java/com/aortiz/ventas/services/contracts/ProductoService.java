package com.aortiz.ventas.services.contracts;

import com.aortiz.ventas.models.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductoService {
    List<Producto> listar();
    void guardar(Producto producto);
    Producto buscar(Long id);
}
