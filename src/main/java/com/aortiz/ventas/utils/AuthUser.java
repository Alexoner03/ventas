package com.aortiz.ventas.utils;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AuthUser extends User {
    private final Long userID;

    public AuthUser(String username, String password,Collection<? extends GrantedAuthority> authorities, Long userID) {
        super(username, password, authorities);
        this.userID = userID;
    }

    public Long getID(){
        return this.userID;
    }
}
