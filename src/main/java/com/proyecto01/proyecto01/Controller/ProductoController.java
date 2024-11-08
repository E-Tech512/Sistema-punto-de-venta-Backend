package com.proyecto01.proyecto01.Controller;

import com.proyecto01.proyecto01.DTO.ProductoDTO;
import com.proyecto01.proyecto01.Model.Categoria;
import com.proyecto01.proyecto01.Model.Producto;
import com.proyecto01.proyecto01.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    @GetMapping
    public List<ProductoDTO> getAllProductos() {
        return productoService.getAllProductos().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> getProductoById(@PathVariable int id) {
        return productoService.getProductoById(id)
                .map(producto -> ResponseEntity.ok(convertToDto(producto)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductoDTO createProducto(@RequestBody ProductoDTO productoDTO) {
        Producto producto = convertToEntity(productoDTO);
        return convertToDto(productoService.createProducto(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable int id, @RequestBody ProductoDTO productoDTO) {
        return productoService.getProductoById(id)
                .map(existingProducto -> {
                    Producto producto = convertToEntity(productoDTO);
                    producto.setIdProducto(existingProducto.getIdProducto());
                    return ResponseEntity.ok(convertToDto(productoService.updateProducto(producto)));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable int id) {
        productoService.deleteProducto(id);
        return ResponseEntity.noContent().build();
    }

    private ProductoDTO convertToDto(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setIdProducto(producto.getIdProducto());
        productoDTO.setCodigo(producto.getCodigo());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setIdCategoria(producto.getCategoria().getIdCategoria());
        productoDTO.setStock(producto.getStock());
        productoDTO.setPrecioCompra(producto.getPrecioCompra());
        productoDTO.setPrecioVenta(producto.getPrecioVenta());
        productoDTO.setEstado(producto.isEstado());
        productoDTO.setFechaRegistro(producto.getFechaRegistro());
        return productoDTO;
    }

    private Producto convertToEntity(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setCodigo(productoDTO.getCodigo());
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setCategoria(new Categoria());
        producto.getCategoria().setIdCategoria(productoDTO.getIdCategoria());
        producto.setStock(productoDTO.getStock());
        producto.setPrecioCompra(productoDTO.getPrecioCompra());
        producto.setPrecioVenta(productoDTO.getPrecioVenta());
        producto.setEstado(productoDTO.isEstado());
        return producto;
    }
}
