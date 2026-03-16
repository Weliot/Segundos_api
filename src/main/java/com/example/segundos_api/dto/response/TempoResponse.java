package com.example.segundos_api.dto.response;

import java.time.LocalDateTime;

import com.example.segundos_api.model.Tempo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "TempoResponse", description = "DTO de resposta para o tempo")
public record TempoResponse(
    
    @Schema(name = "idTempo", example = "1", description = "ID do tempo")
    @NotBlank(message = "ID do tempo deve ser preenchido")
    Long idTempo,

    @Schema(name = "tempoEstudo", example = "48945210587", description = "tempo total de estudo em milisegundos")
    @NotBlank(message = "Tempo de estudo deve ser preenchido")
    Long tempoEstudo,

    @Schema(name = "idMateria", example = "1", description = "ID da matéria relacionada ao tempo")
    @NotBlank(message = "ID da matéria deve ser preenchido")
    Long idMateria,
    
    @Schema(name = "idAssunto", example = "1", description = "ID do assunto relacionado ao tempo")
    @NotBlank(message = "ID do assunto deve ser preenchido")
    Long idAssunto,

    @Schema(name = "dataRegistro", example = "2023-10-01 12:00:00", description = "Data e hora do registro do tempo")
    @NotBlank(message = "Data de registro deve ser preenchida")
    LocalDateTime dataRegistro
) {

    public static TempoResponse fromEntity(Tempo tempo) {
        return new TempoResponse(
            tempo.getIdTempo(),
            tempo.getTempoEstudo(),
            tempo.getIdMateria(),
            tempo.getIdAssunto(),
            tempo.getDataRegistro()
        );
    }
}