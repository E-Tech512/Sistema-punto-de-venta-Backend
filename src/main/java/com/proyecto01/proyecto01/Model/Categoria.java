package com.proyecto01.proyecto01.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdCategoria;

    private String Descripcion;

    private boolean Estado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaRegistro = new Date();
}
