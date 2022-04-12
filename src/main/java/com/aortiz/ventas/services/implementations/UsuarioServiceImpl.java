package com.aortiz.ventas.services.implementations;

import com.aortiz.ventas.dao.UsuarioDAO;
import com.aortiz.ventas.models.Rol;
import com.aortiz.ventas.models.Usuario;
import com.aortiz.ventas.services.contracts.UsuarioService;
import com.aortiz.ventas.utils.AuthUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
@Slf4j
public class UsuarioServiceImpl implements UserDetailsService, UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDAO.findByNombre(username);

        if(usuario == null){
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        for (Rol rol: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getDescripcion()));
        }

        return new AuthUser(usuario.getNombre(), usuario.getPassword(), roles, usuario.getId());
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioDAO.findById(id).orElse(null);
    }
}
