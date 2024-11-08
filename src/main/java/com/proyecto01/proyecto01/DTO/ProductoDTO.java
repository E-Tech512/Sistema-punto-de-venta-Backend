package com.proyecto01.proyecto01.DTO;
import lombok.Data;

import java.util.Date;

@Data
public class ProductoDTO {
    private int IdProducto;
    private String Codigo;
    private String Nombre;
    private String Descripcion;
    private int IdCategoria;
    private int Stock;
    private double PrecioCompra;
    private double PrecioVenta;
    private boolean Estado;
    private Date FechaRegistro;
}
