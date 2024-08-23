package com.microservice.books.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LibroDTO implements Serializable {

    private Long id;
    private String titulo;
    private Integer numeroPaginas;
    private String categoriaNombre;
    private String autorNombreCompleto;

}
