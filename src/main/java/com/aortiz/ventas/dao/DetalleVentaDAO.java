package com.aortiz.ventas.dao;

import com.aortiz.ventas.models.DetalleVenta;
import com.aortiz.ventas.models.DetalleVentaKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaDAO extends JpaRepository<DetalleVenta, DetalleVentaKey> {
}
