package com.example.segundos_api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema (name = "TempoRequest", description = "DTO de requisição para o tempo")
public record TempoRequest(

    @Schema (name = "idAssunto", example = "1", description = "ID do assunto relacionado ao tempo")
    @NotBlank(message = "ID do assunto deve ser preenchido")
    Long idAssunto,

    @Schema (name = "idMateria", example = "1", description = "ID da matéria relacionada ao tempo")
    @NotBlank(message = "ID da matéria deve ser preenchido")
    Long idMateria,

    @Schema (name = "tempoEstudo", example = "48945210587", description = "Tempo total de estudo em milisegundos")
    @NotBlank(message = "Tempo de estudo deve ser preenchido")
    Long tempoEstudo
) {}
