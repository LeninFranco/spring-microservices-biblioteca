package com.microservice.loans.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "loans")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id")
    private Long idLibro;

    @Column(name = "member_id")
    private Long idMiembro;

    @Column(name = "loan_date", columnDefinition = "DATE")
    private LocalDate fechaPrestamo;

    @Column(name = "return_date", columnDefinition = "DATE")
    private LocalDate fechaRegreso;
}
