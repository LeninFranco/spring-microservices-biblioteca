package com.microservice.books.repositories;

import com.microservice.books.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findAllByCategoriaId(Long categoriaId);

    List<Libro> findAllByAutorId(Long autorId);
}
