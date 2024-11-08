package com.proyecto01.proyecto01.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdProducto;

    private String Codigo;
    private String Nombre;
    private String Descripcion;

    @ManyToOne
    @JoinColumn(name = "IdCategoria", nullable = false)
    private Categoria categoria;

    private int Stock;
    private double PrecioCompra;
    private double PrecioVenta;
    private boolean Estado;

    @Temporal(TemporalType.TIMESTAMP)
    private Date FechaRegistro = new Date();
}
