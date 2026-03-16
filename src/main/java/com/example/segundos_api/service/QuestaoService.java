package com.example.segundos_api.service;

import java.util.List;

import com.example.segundos_api.dto.request.QuestaoRequest;
import com.example.segundos_api.model.Questao;

public interface QuestaoService {

    Questao createQuestao(QuestaoRequest questaoRequest);
    Questao getQuestaoById(Long idQuestao);
    List<Questao> getAllQuestoes();
    List<Questao> getQuestoesByIdMateria(Long idMateria);
    List<Questao> getQuestoesByIdAssunto(Long idAssunto);
    
}
