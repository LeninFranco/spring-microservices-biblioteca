package com.microservice.loans.client;

import com.microservice.loans.dto.LibroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-book", url = "localhost:8090/libros")
public interface BooksClient {

    @GetMapping("/{id}")
    LibroDTO getLibro(@PathVariable Long id);
}
