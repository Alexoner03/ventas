package com.aortiz.ventas.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDE_USR")
    private Long id;

    @NotEmpty
    @Column(name = "NOM_USR")
    private String nombre;

    @Column(name = "PAS_USR")
    @NotEmpty
    private String password;

    @OneToMany
    @JoinColumn(name="IDE_USR")
    private List<Rol> roles;
}
