package com.microservice.books.services;

import com.microservice.books.dto.CategoriaDTO;
import com.microservice.books.dto.CategoriaRequestDTO;
import com.microservice.books.entities.Categoria;
import com.microservice.books.exceptions.ItemNotFoundException;
import com.microservice.books.repositories.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<CategoriaDTO> findAllCategorias(){
        return categoriaRepository.findAll().stream()
                .map(categoria -> modelMapper.map(categoria, CategoriaDTO.class))
                .collect(Collectors.toList());
    }

    public CategoriaDTO findCategoria(Long id){
        return categoriaRepository.findById(id)
                .map(categoria -> modelMapper.map(categoria, CategoriaDTO.class))
                .orElseThrow(() -> new ItemNotFoundException("Categoria no encontrada con el ID: " + id));

    }

    public CategoriaDTO createCategoria(CategoriaRequestDTO categoriaRequestDTO){
        Categoria categoria = modelMapper.map(categoriaRequestDTO, Categoria.class);
        return modelMapper.map(categoriaRepository.save(categoria), CategoriaDTO.class);
    }

    public CategoriaDTO updateCategoria(Long id, CategoriaRequestDTO categoriaRequestDTO){
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Categoria no encontrada con el ID: " + id));
        categoria.setNombre(categoriaRequestDTO.getNombre());
        return modelMapper.map(categoriaRepository.save(categoria), CategoriaDTO.class);
    }

}
