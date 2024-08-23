package com.microservice.loans.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrestamoDTO implements Serializable {
    private Long id;
    private LibroDTO libro;
    private MiembroDTO miembro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaRegreso;
}
