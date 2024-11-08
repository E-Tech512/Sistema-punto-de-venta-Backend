package com.proyecto01.proyecto01.Service;

import com.proyecto01.proyecto01.Model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {
    List<Producto> getAllProductos();
    Optional<Producto> getProductoById(int id);
    Producto createProducto(Producto producto);
    Producto updateProducto(Producto producto);
    void deleteProducto(int id);
}
