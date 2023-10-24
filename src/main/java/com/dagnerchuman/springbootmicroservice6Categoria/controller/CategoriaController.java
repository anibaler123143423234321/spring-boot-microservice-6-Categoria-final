package com.dagnerchuman.springbootmicroservice6Categoria.controller;

import com.dagnerchuman.springbootmicroservice6Categoria.model.Categoria;
import com.dagnerchuman.springbootmicroservice6Categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<?> saveCategoria(@RequestBody Categoria categoria) {
        return new ResponseEntity<>(
                categoriaService.saveCategoria(categoria),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<?> getAllCategorias() {
        return ResponseEntity.ok(categoriaService.findAllCategorias());
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<?> getCategoriaById(@PathVariable Long categoriaId) {
        try {
            Categoria categoria = categoriaService.findCategoriaById(categoriaId);
            return ResponseEntity.ok(categoria);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{categoriaId}")
    public ResponseEntity<?> updateCategoria(
            @PathVariable Long categoriaId,
            @RequestBody Categoria categoria) {
        try {
            Categoria existingCategoria = categoriaService.findCategoriaById(categoriaId);
            categoria.setId(categoriaId);
            return ResponseEntity.ok(categoriaService.saveCategoria(categoria));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Long categoriaId) {
        try {
            categoriaService.deleteCategoria(categoriaId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
