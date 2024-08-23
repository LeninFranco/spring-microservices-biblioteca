package com.microservice.members.controllers;

import com.microservice.members.dto.MiembroDTO;
import com.microservice.members.dto.MiembroRequestDTO;
import com.microservice.members.services.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/miembros")
public class MiembroController {

    @Autowired
    private MiembroService miembroService;

    @GetMapping
    public ResponseEntity<List<MiembroDTO>> getAllMiembros(){
        return ResponseEntity.ok(miembroService.findAllMiembros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MiembroDTO> getMiembro(@PathVariable Long id){
        return ResponseEntity.ok(miembroService.findMiembro(id));
    }

    @PostMapping
    public ResponseEntity<MiembroDTO> postMiembro(@RequestBody MiembroRequestDTO miembroRequestDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(miembroService.createMiembro(miembroRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MiembroDTO> putMiembro(@PathVariable Long id, @RequestBody MiembroRequestDTO miembroRequestDTO){
        return ResponseEntity.ok(miembroService.updateMiembro(id,miembroRequestDTO));
    }
}
