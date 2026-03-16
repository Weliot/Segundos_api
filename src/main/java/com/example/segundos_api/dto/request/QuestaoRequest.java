package com.example.segundos_api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "QuestaoRequest", description = "DTO de requisição para a questão")
public record QuestaoRequest(

    @Schema(name = "qtdQuestoes", example = "10", description = "Quantidade de questões a serem geradas")
    Long qtdQuestoes,

    @Schema(name ="qtdAcertos" , example = "8", description = "Quantidade de acertos")
    Long qtdAcertos,

    @Schema(name = "qtdErros", example = "2", description = "Quantidade de erros")
    Long qtdErros,

    @Schema(name = "idAssunto", example = "1", description = "ID do assunto relacionado à questão")
    Long idAssunto,

    @Schema(name = "idMateria", example = "1", description = "ID da matéria relacionada à questão")
    Long idMateria,

    @Schema(name = "idUsuario", example = "1", description = "ID do usuário que registrou a questão")
    Long idUsuario

) {}