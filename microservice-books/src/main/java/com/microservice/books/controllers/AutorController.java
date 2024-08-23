package com.microservice.books.controllers;

import com.microservice.books.dto.AutorDTO;
import com.microservice.books.dto.AutorRequestDTO;
import com.microservice.books.dto.LibroDTO;
import com.microservice.books.services.AutorService;
import com.microservice.books.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<AutorDTO>> getAllAutores(){
        return ResponseEntity.ok(autorService.findAllAutores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> getAutor(@PathVariable Long id){
        return ResponseEntity.ok(autorService.findAutor(id));
    }

    @GetMapping("/{id}/libros")
    public ResponseEntity<List<LibroDTO>> getLibrosPorAutor(@PathVariable Long id){
        return ResponseEntity.ok(libroService.findAllLibrosByAutor(id));
    }

    @PostMapping
    public ResponseEntity<AutorDTO> postAutor(@RequestBody AutorRequestDTO autorRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.createAutor(autorRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> putAutor(@PathVariable Long id, @RequestBody AutorRequestDTO autorRequestDTO){
        return ResponseEntity.ok(autorService.updateAutor(id,autorRequestDTO));
    }
}
