package com.aortiz.ventas.dao;

import com.aortiz.ventas.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaDAO extends JpaRepository<Venta, Long> { }
