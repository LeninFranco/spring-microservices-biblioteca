package com.microservice.loans.client;

import com.microservice.loans.dto.MiembroDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msvc-members", url = "localhost:8092/miembros")
public interface MembersClient {

    @GetMapping("/{id}")
    MiembroDTO getMiembro(@PathVariable Long id);
}
