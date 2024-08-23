package com.microservice.loans.services;

import com.microservice.loans.client.BooksClient;
import com.microservice.loans.client.MembersClient;
import com.microservice.loans.dto.LibroDTO;
import com.microservice.loans.dto.MiembroDTO;
import com.microservice.loans.dto.PrestamoDTO;
import com.microservice.loans.dto.PrestamoRequestDTO;
import com.microservice.loans.entities.Prestamo;
import com.microservice.loans.exceptions.ItemNotFoundException;
import com.microservice.loans.repositories.PrestamoRepository;
import feign.FeignException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private BooksClient booksClient;

    @Autowired
    private MembersClient membersClient;

    public PrestamoDTO createPrestamo(PrestamoRequestDTO prestamoRequestDTO){
        try{
            LibroDTO libro = booksClient.getLibro(prestamoRequestDTO.getIdLibro());
            MiembroDTO miembro = membersClient.getMiembro(prestamoRequestDTO.getIdMiembro());

            Prestamo prestamo = Prestamo.builder()
                    .idLibro(libro.getId())
                    .idMiembro(miembro.getId())
                    .fechaPrestamo(LocalDate.now())
                    .fechaRegreso(LocalDate.now().plusDays(30))
                    .build();

            Prestamo savedPrestamo = prestamoRepository.save(prestamo);

            return PrestamoDTO.builder()
                    .id(savedPrestamo.getId())
                    .libro(libro)
                    .miembro(miembro)
                    .fechaPrestamo(savedPrestamo.getFechaPrestamo())
                    .fechaRegreso(savedPrestamo.getFechaRegreso())
                    .build();
        } catch (FeignException.NotFound ex){
            throw new ItemNotFoundException("Libro o Miembro no encontrado");
        }
    }

    public List<PrestamoDTO> findAllPrestamos(){
        return prestamoRepository.findAll().stream()
                .map(prestamo -> PrestamoDTO.builder()
                        .id(prestamo.getId())
                        .libro(booksClient.getLibro(prestamo.getIdLibro()))
                        .miembro(membersClient.getMiembro(prestamo.getIdMiembro()))
                        .fechaPrestamo(prestamo.getFechaPrestamo())
                        .fechaRegreso(prestamo.getFechaRegreso())
                        .build()
                ).collect(Collectors.toList());
    }

    public PrestamoDTO findPrestamo(Long id){
        return prestamoRepository.findById(id)
                .map(prestamo -> PrestamoDTO.builder()
                        .id(prestamo.getId())
                        .libro(booksClient.getLibro(prestamo.getIdLibro()))
                        .miembro(membersClient.getMiembro(prestamo.getIdMiembro()))
                        .fechaPrestamo(prestamo.getFechaPrestamo())
                        .fechaRegreso(prestamo.getFechaRegreso())
                        .build()
                ).orElseThrow(() -> new ItemNotFoundException("Prestamo no encontrado con ID: " + id));
    }
}
