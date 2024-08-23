package com.microservice.members.services;

import com.microservice.members.dto.MiembroDTO;
import com.microservice.members.dto.MiembroRequestDTO;
import com.microservice.members.entities.Miembro;
import com.microservice.members.exceptions.ItemNotFoundException;
import com.microservice.members.repositories.MiembroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MiembroService {

    @Autowired
    private MiembroRepository miembroRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<MiembroDTO> findAllMiembros(){
        return miembroRepository.findAll().stream()
                .map(miembro -> modelMapper.map(miembro, MiembroDTO.class))
                .collect(Collectors.toList());
    }

    public MiembroDTO findMiembro(Long id){
        return miembroRepository.findById(id)
                .map(miembro -> modelMapper.map(miembro, MiembroDTO.class))
                .orElseThrow(() -> new ItemNotFoundException("Miembro no encontrado con ID: " + id));
    }

    public MiembroDTO createMiembro(MiembroRequestDTO miembroRequestDTO){
        Miembro miembro = modelMapper.map(miembroRequestDTO, Miembro.class);
        return modelMapper.map(miembroRepository.save(miembro), MiembroDTO.class);
    }

    public MiembroDTO updateMiembro(Long id, MiembroRequestDTO miembroRequestDTO){
        Miembro miembro = miembroRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Miembro no encontrado con ID: " + id));
        miembro.setNombreCompleto(miembroRequestDTO.getNombreCompleto());
        miembro.setEmail(miembroRequestDTO.getEmail());
        miembro.setEmail(miembroRequestDTO.getEmail());
        return modelMapper.map(miembroRepository.save(miembro), MiembroDTO.class);
    }
}
