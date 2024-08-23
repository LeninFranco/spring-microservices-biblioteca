package com.microservice.books.controllers;

import com.microservice.books.dto.CategoriaDTO;
import com.microservice.books.dto.CategoriaRequestDTO;
import com.microservice.books.dto.LibroDTO;
import com.microservice.books.services.CategoriaService;
import com.microservice.books.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAllCategorias(){
        return ResponseEntity.ok(categoriaService.findAllCategorias());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getCategoria(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.findCategoria(id));
    }

    @GetMapping("/{id}/libros")
    public ResponseEntity<List<LibroDTO>> getLibrosPorCategoria(@PathVariable Long id){
        return ResponseEntity.ok(libroService.findAllLibrosByCategoria(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> postCategoria(@RequestBody CategoriaRequestDTO categoriaRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.createCategoria(categoriaRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> putCategoria(@PathVariable Long id, @RequestBody CategoriaRequestDTO categoriaRequestDTO){
        return ResponseEntity.ok(categoriaService.updateCategoria(id, categoriaRequestDTO));
    }
}
