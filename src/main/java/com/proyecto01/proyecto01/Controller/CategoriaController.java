package com.proyecto01.proyecto01.Controller;

import com.proyecto01.proyecto01.DTO.CategoriaDTO;
import com.proyecto01.proyecto01.Model.Categoria;
import com.proyecto01.proyecto01.Service.ICategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("http://localhost:4200/")
public class CategoriaController {
    @Autowired
    private ICategoriaService categoriaService;

    @GetMapping
    public List<CategoriaDTO> getAllCategorias() {
        return categoriaService.getAllCategorias().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable int id) {
        return categoriaService.getCategoriaById(id)
                .map(categoria -> ResponseEntity.ok(convertToDto(categoria)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public CategoriaDTO createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria categoria = convertToEntity(categoriaDTO);
        return convertToDto(categoriaService.createCategoria(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable int id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }

    /* MODIFICACIÓN DE LOS ELEMETNOS DE LAS CATEGORIAS*/

    private CategoriaDTO convertToDto(Categoria categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setIdCategoria(categoria.getIdCategoria());
        categoriaDTO.setDescripcion(categoria.getDescripcion());
        categoriaDTO.setEstado(categoria.isEstado());
        categoriaDTO.setFechaRegistro(categoria.getFechaRegistro());
        return categoriaDTO;
    }

    private Categoria convertToEntity(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setDescripcion(categoriaDTO.getDescripcion());
        categoria.setEstado(categoriaDTO.isEstado());
        return categoria;
    }
}