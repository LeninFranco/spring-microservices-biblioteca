package com.microservice.books.services;

import com.microservice.books.dto.LibroDTO;
import com.microservice.books.dto.LibroRequestDTO;
import com.microservice.books.entities.Autor;
import com.microservice.books.entities.Categoria;
import com.microservice.books.entities.Libro;
import com.microservice.books.exceptions.ItemNotFoundException;
import com.microservice.books.repositories.AutorRepository;
import com.microservice.books.repositories.CategoriaRepository;
import com.microservice.books.repositories.LibroRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<LibroDTO> findAllLibros(){
        return libroRepository.findAll().stream()
                .map(libro -> modelMapper.map(libro, LibroDTO.class))
                .collect(Collectors.toList());
    }

    public List<LibroDTO> findAllLibrosByCategoria(Long idCategoria){
        return libroRepository.findAllByCategoriaId(idCategoria).stream()
                .map(libro -> modelMapper.map(libro, LibroDTO.class))
                .collect(Collectors.toList());
    }

    public List<LibroDTO> findAllLibrosByAutor(Long idAutor){
        return libroRepository.findAllByAutorId(idAutor).stream()
                .map(libro -> modelMapper.map(libro, LibroDTO.class))
                .collect(Collectors.toList());
    }

    public LibroDTO findLibro(Long id){
        return libroRepository.findById(id)
                .map(libro -> modelMapper.map(libro, LibroDTO.class))
                .orElseThrow(() -> new ItemNotFoundException("Libro no encontrado con ID: " + id));
    }

    public LibroDTO createLibro(LibroRequestDTO libroRequestDTO){
        Categoria categoria = categoriaRepository.findById(libroRequestDTO.getIdCategoria()).orElseThrow(() -> new ItemNotFoundException("Categoria no encontrada con ID: " + libroRequestDTO.getIdCategoria()));
        Autor autor = autorRepository.findById(libroRequestDTO.getIdAutor()).orElseThrow(() -> new ItemNotFoundException("Autor no encontrado con ID: " + libroRequestDTO.getIdAutor()));

        Libro libro = Libro.builder()
                .titulo(libroRequestDTO.getTitulo())
                .numeroPaginas(libroRequestDTO.getNumeroPaginas())
                .categoria(categoria)
                .autor(autor)
                .build();

        return modelMapper.map(libroRepository.save(libro), LibroDTO.class);
    }

    public LibroDTO updateLibro(Long id, LibroRequestDTO libroRequestDTO){
        Libro libro = libroRepository.findById(id).orElseThrow(() -> new ItemNotFoundException("Libro no encontrado con ID: " + id));
        Categoria categoria = categoriaRepository.findById(libroRequestDTO.getIdCategoria()).orElseThrow(() -> new ItemNotFoundException("Categoria no encontrada con ID: " + libroRequestDTO.getIdCategoria()));
        Autor autor = autorRepository.findById(libroRequestDTO.getIdAutor()).orElseThrow(() -> new ItemNotFoundException("Autor no encontrado con ID: " + libroRequestDTO.getIdAutor()));

        libro.setTitulo(libroRequestDTO.getTitulo());
        libro.setNumeroPaginas(libroRequestDTO.getNumeroPaginas());
        libro.setCategoria(categoria);
        libro.setAutor(autor);

        return modelMapper.map(libroRepository.save(libro), LibroDTO.class);
    }
}
