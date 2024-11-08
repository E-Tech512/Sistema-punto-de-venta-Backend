package com.proyecto01.proyecto01.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class CategoriaDTO {
    private int IdCategoria;
    private String Descripcion;
    private boolean Estado;
    private Date FechaRegistro;
}
