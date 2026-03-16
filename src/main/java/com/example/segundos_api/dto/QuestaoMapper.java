package com.example.segundos_api.dto;

import com.example.segundos_api.dto.response.QuestaoResponse;
import com.example.segundos_api.model.Questao;

public class QuestaoMapper {

    public static QuestaoResponse toResponse(Questao questao) {
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
