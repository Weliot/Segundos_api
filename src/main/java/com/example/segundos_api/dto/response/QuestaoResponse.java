package com.example.segundos_api.dto.response;

import java.time.LocalDateTime;

import com.example.segundos_api.model.Questao;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "QuestaoResponse", description = "DTO de resposta para questões")
public record QuestaoResponse(
    @Schema(name = "idQuestoes", example = "1", description = "ID da questão")
    @NotBlank(message = "ID da questão deve ser preenchido")
    Long idQuestoes,

    @Schema(name = "qtdQuestoes", example = "10", description = "Quantidade de questões")
    @NotBlank(message = "Quantidade de questões deve ser preenchida")
    Long qtdQuestoes,

    @Schema(name = "qtdAcertos", example = "7", description = "Quantidade de acertos")
    @NotBlank(message = "Quantidade de acertos deve ser preenchida")
    Long qtdAcertos,

    @Schema(name = "qtdErros", example = "3", description = "Quantidade de erros")
    @NotBlank(message = "Quantidade de erros deve ser preenchida")
    Long qtdErros,

    @Schema(name = "idAssunto", example = "1", description = "ID do assunto relacionado à questão")
    @NotBlank(message = "ID do assunto deve ser preenchido")
    Long idAssunto,

    @Schema(name = "idMateria", example = "1", description = "ID da matéria relacionada à questão")
    @NotBlank(message = "ID da matéria deve ser preenchido")
    Long idMateria,

    @Schema(name = "idUsuario", example = "1", description = "ID do usuário que registrou a questão")
    @NotBlank(message = "ID do usuário deve ser preenchido")
    Long idUsuario,

    @Schema(name = "dataRegistro", example = "2023-10-01 12:00:00", description = "Data e hora do registro da questão")
    @NotBlank(message = "Data de registro deve ser preenchida")
    LocalDateTime dataRegistro
) {

    public static QuestaoResponse fromEntity(Questao questao) {
        return new QuestaoResponse(
            questao.getIdQuestoes(),
            questao.getQtdQuestoes(),
            questao.getQtdAcertos(),
            questao.getQtdErros(),
            questao.getIdAssunto(),
            questao.getIdMateria(),
            questao.getIdUsuario(),
            questao.getDataRegistro()
        );
    }
    
}
