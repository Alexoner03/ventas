package com.aortiz.ventas.services.implementations;

import com.aortiz.ventas.services.contracts.AuthHelper;
import com.aortiz.ventas.utils.AuthUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthHelperImpl implements AuthHelper {

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    public String getName() {
        return getAuthentication().getName();
    }
    public UserDetails getUserDetails() {
        return (UserDetails) getAuthentication().getPrincipal();
    }

    public Long getID() {
        AuthUser user = (AuthUser) getAuthentication().getPrincipal();
        return user.getID();
    }
}
