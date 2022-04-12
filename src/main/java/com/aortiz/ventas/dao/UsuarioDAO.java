package com.aortiz.ventas.dao;

import com.aortiz.ventas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDAO extends JpaRepository<Usuario, Long> {
    Usuario findByNombre(String nombre);
}
