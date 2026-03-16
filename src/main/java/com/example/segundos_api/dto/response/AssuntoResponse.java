package com.example.segundos_api.dto.response;

import com.example.segundos_api.model.Assunto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "AssuntoResponse", description = "DTO de resposta para")
public record AssuntoResponse(

    @Schema(name = "idAssunto", example = "1", description = "ID do assunto")
    @NotBlank (message = "ID do assunto deve ser preenchido")
    Long idAssunto,
    
    @Schema(name = "nomeAssunto", example = "Literatura", description = "Nome do assunto")
    @NotBlank (message = "Nome do Assunto deve ser preenchido")
    String nomeAssunto,

    @Schema(name = "idMateria", example = "1", description = "ID da matéria relacionada ao assunto")
    @NotBlank (message = "ID da matéria deve ser preenchido")
    Long idMateria

) {

    public static AssuntoResponse fromEntity(Assunto assunto) {
        return new AssuntoResponse(
            assunto.getIdAssunto(),
            assunto.getNomeAssunto(),
            assunto.getIdMateria()
        );
    }
}
