package com.dagnerchuman.springbootmicroservice6Categoria.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name="foto", length = 1200, nullable = true )
    private String picture;

    @Column(name = "negocio_id", nullable = false)
    private Long negocioId;

    @Column(name="fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

}

