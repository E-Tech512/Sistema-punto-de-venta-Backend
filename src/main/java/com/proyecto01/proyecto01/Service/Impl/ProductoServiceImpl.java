package com.proyecto01.proyecto01.Service.Impl;

import com.proyecto01.proyecto01.Model.Producto;
import com.proyecto01.proyecto01.Repository.CategoriaRepository;
import com.proyecto01.proyecto01.Repository.ProductoRepository;
import com.proyecto01.proyecto01.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements IProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> getProductoById(int id) {
        return productoRepository.findById(id);
    }

    @Override
    public Producto createProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(int id) {
        productoRepository.deleteById(id);
    }
}
