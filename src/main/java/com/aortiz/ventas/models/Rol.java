package com.aortiz.ventas.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ROL")
public class Rol implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDE_ROL")
    private Long id;

    @NotEmpty
    @Column(name = "DSC_ROL")
    private String descripcion;
}
