package com.example.segundos_api.dto;

import com.example.segundos_api.dto.response.AssuntoResponse;
import com.example.segundos_api.model.Assunto;

public class AssuntoMapper {

    public static AssuntoResponse toResponse(Assunto assunto){
        return new AssuntoResponse(
            assunto.getIdAssunto(),
            assunto.getNomeAssunto(),
            assunto.getIdMateria()
        );
    }
    
}
