package com.proyecto01.proyecto01.Service;

import com.proyecto01.proyecto01.Model.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    List<Categoria> getAllCategorias();
    Optional<Categoria> getCategoriaById(int id);
    Categoria createCategoria(Categoria categoria);
    Categoria updateCategoria(Categoria categoria);
    void deleteCategoria(int id);
}