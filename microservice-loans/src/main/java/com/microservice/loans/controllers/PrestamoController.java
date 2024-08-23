package com.microservice.loans.controllers;

import com.microservice.loans.dto.PrestamoDTO;
import com.microservice.loans.dto.PrestamoRequestDTO;
import com.microservice.loans.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public ResponseEntity<List<PrestamoDTO>> getAllPrestamos(){
        return ResponseEntity.ok(prestamoService.findAllPrestamos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestamoDTO> getPrestamos(@PathVariable Long id){
        return ResponseEntity.ok(prestamoService.findPrestamo(id));
    }

    @PostMapping
    public ResponseEntity<PrestamoDTO> postPrestamo(@RequestBody PrestamoRequestDTO prestamoRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(prestamoService.createPrestamo(prestamoRequestDTO));
    }
}
