package com.microservice.books.services;

import com.microservice.books.dto.AutorDTO;
import com.microservice.books.dto.AutorRequestDTO;
import com.microservice.books.entities.Autor;
import com.microservice.books.exceptions.ItemNotFoundException;
import com.microservice.books.repositories.AutorRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<AutorDTO> findAllAutores(){
        return autorRepository.findAll().stream()
                .map(autor -> modelMapper.map(autor, AutorDTO.class))
                .collect(Collectors.toList());
    }

    public AutorDTO findAutor(Long id){
        return autorRepository.findById(id)
                .map(autor -> modelMapper.map(autor, AutorDTO.class))
                .orElseThrow(() -> new ItemNotFoundException("Autor no encontrado con el ID: " + id));
    }

    public AutorDTO createAutor(AutorRequestDTO autorRequestDTO){
        Autor autor = modelMapper.map(autorRequestDTO, Autor.class);
        return modelMapper.map(autorRepository.save(autor), AutorDTO.class);
    }

    public AutorDTO updateAutor(Long id, AutorRequestDTO autorRequestDTO){
        Autor autor = autorRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Autor no encontrado con el ID: " + id));
        autor.setNombreCompleto(autorRequestDTO.getNombreCompleto());
        return modelMapper.map(autorRepository.save(autor), AutorDTO.class);
    }
}
