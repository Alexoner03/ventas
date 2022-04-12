package com.aortiz.ventas.services.contracts;

import com.aortiz.ventas.models.Usuario;

public interface UsuarioService {
    Usuario findById(Long id);
}
