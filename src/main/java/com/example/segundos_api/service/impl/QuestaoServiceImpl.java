package com.example.segundos_api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.segundos_api.dto.request.QuestaoRequest;
import com.example.segundos_api.model.Questao;
import com.example.segundos_api.repository.QuestaoRepository;
import com.example.segundos_api.service.QuestaoService;

@Service
public class QuestaoServiceImpl implements QuestaoService {

    private final QuestaoRepository questaoRepository;

    public QuestaoServiceImpl(QuestaoRepository questaoRepository) {
        this.questaoRepository = questaoRepository;
    }

    @Override
    public Questao createQuestao(QuestaoRequest questaoRequest) {
        
        Questao questao = new Questao();
        questao.setQtdQuestoes(questaoRequest.qtdQuestoes());
        questao.setQtdAcertos(questaoRequest.qtdAcertos());
        questao.setQtdErros(questaoRequest.qtdErros());
        questao.setIdMateria(questaoRequest.idMateria());
        questao.setIdAssunto(questaoRequest.idAssunto());
        questao.setIdUsuario(questaoRequest.idUsuario());

        return questaoRepository.save(questao);
    }

    @SuppressWarnings("null")
    @Override
    public Questao getQuestaoById(Long idQuestao) {
        return questaoRepository.findById(idQuestao).orElse(null);
    }

    @Override
    public List<Questao> getAllQuestoes() {
        return questaoRepository.findAll();
    }

    @Override
    public List<Questao> getQuestoesByIdMateria(Long idMateria) {
        return questaoRepository.findByIdMateria(idMateria);
    }

    @Override
    public List<Questao> getQuestoesByIdAssunto(Long idAssunto) {
        return questaoRepository.findByIdAssunto(idAssunto);
    }
    
}
