package com.dagnerchuman.springbootmicroservice6Categoria.service;

import com.dagnerchuman.springbootmicroservice6Categoria.model.Categoria;

import java.util.List;

public interface CategoriaService {
    Categoria saveCategoria(Categoria categoria);

    List<Categoria> findAllCategorias();

    Categoria findCategoriaById(Long categoriaId);

    void deleteCategoria(Long categoriaId);

    // Otros métodos relacionados con la gestión de categorías
}
