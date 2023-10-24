package com.dagnerchuman.springbootmicroservice6Categoria.service;

import com.dagnerchuman.springbootmicroservice6Categoria.model.Categoria;
import com.dagnerchuman.springbootmicroservice6Categoria.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria saveCategoria(Categoria categoria) {

        categoria.setFechaCreacion(LocalDateTime.now());
        return categoriaRepository.save(categoria);
    }

    @Override
    public List<Categoria> findAllCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria findCategoriaById(Long categoriaId) {
        return categoriaRepository.findById(categoriaId).orElse(null);
    }

    @Override
    public void deleteCategoria(Long categoriaId) {
        categoriaRepository.deleteById(categoriaId);
    }

    // Otros métodos relacionados con la gestión de categorías
}

