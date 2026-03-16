package com.example.segundos_api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema (name = "AssuntoRequest", description = "DTO de requisição de assuntos")
public record AssuntoRequest(

    @Schema(name = "nomeAssunto", example = "Literatura")
    @NotBlank (message = "Nome do assunto deve ser preenchido")
    String nomeAssunto,

    @Schema(name = "idMateria", example = "1")
    @NotBlank (message = "ID da matéria deve ser preenchido")
    Long idMateria
    
 ) {}
