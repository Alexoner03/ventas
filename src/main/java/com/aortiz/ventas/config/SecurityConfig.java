package com.aortiz.ventas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private EncoderConfig encoderConfig;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoderConfig.getEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login*","/login").permitAll()
                .antMatchers("/productos/**", "/usuarios/**", "/reportes/**").hasRole("ADMINISTRADOR")
                .antMatchers("/productos/**", "/usuarios/**", "/reportes/**").authenticated()
                .antMatchers("/ventas","/ventas/**").authenticated()
                .and().formLogin().loginPage("/login")
                .and().exceptionHandling().accessDeniedPage("/errors/403");
    }
}
