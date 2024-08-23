package com.microservice.books.controllers;

import com.microservice.books.dto.LibroDTO;
import com.microservice.books.dto.LibroRequestDTO;
import com.microservice.books.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<LibroDTO>> getAllLibros(){
        return ResponseEntity.ok(libroService.findAllLibros());
    }

    @GetMapping("/categoria/{idCategoria}")
    public ResponseEntity<List<LibroDTO>> getAllLibrosByCategoria(@PathVariable Long idCategoria){
        return ResponseEntity.ok(libroService.findAllLibrosByCategoria(idCategoria));
    }

    @GetMapping("/autor/{idAutor}")
    public ResponseEntity<List<LibroDTO>> getAllLibrosByAutor(@PathVariable Long idAutor){
        return ResponseEntity.ok(libroService.findAllLibrosByAutor(idAutor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibroDTO> getLibro(@PathVariable Long id){
        return ResponseEntity.ok(libroService.findLibro(id));
    }

    @PostMapping
    public ResponseEntity<LibroDTO> postLibro(@RequestBody LibroRequestDTO libroRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(libroService.createLibro(libroRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LibroDTO> putLibro(@PathVariable Long id, @RequestBody LibroRequestDTO libroRequestDTO){
        return ResponseEntity.ok(libroService.updateLibro(id,libroRequestDTO));
    }

}
