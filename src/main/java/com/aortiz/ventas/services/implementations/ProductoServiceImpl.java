package com.aortiz.ventas.services.implementations;

import com.aortiz.ventas.dao.ProductoDAO;
import com.aortiz.ventas.models.Producto;
import com.aortiz.ventas.services.contracts.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDAO productoDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> listar() {
        return productoDAO.findAll();
    }

    @Override
    @Transactional()
    public void guardar(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    public Producto buscar(Long id) {
        return productoDAO.findById(id).orElse(null);
    }
}
