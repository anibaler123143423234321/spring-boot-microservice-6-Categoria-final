package com.dagnerchuman.springbootmicroservice6Categoria.repository;

import com.dagnerchuman.springbootmicroservice6Categoria.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
