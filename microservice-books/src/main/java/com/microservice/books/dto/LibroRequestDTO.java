package com.microservice.books.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroRequestDTO implements Serializable {
    private String titulo;
    private Integer numeroPaginas;
    private Long idCategoria;
    private Long idAutor;
}
