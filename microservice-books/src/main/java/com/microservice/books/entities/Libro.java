package com.microservice.books.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "books")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titulo;

    @Column(name = "numero_paginas")
    private Integer numeroPaginas;

    @ManyToOne(targetEntity = Categoria.class)
    private Categoria categoria;

    @ManyToOne(targetEntity = Autor.class)
    private Autor autor;
}
