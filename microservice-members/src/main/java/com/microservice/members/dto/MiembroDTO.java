package com.microservice.members.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MiembroDTO implements Serializable {

    private Long id;
    private String nombreCompleto;
    private String email;
    private String telefono;
}
