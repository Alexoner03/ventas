package com.aortiz.ventas.services.contracts;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

public interface AuthHelper {
    Authentication getAuthentication();
    String getName();
    UserDetails getUserDetails();
    public Long getID();
}