package com.aortiz.ventas.dao;

import com.aortiz.ventas.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDAO extends JpaRepository<Producto, Long> {
}
