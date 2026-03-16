package com.example.segundos_api.controller;

import org.springframework.web.bind.annotation.*;

import com.example.segundos_api.dto.QuestaoMapper;
import com.example.segundos_api.dto.request.QuestaoRequest;
import com.example.segundos_api.dto.response.QuestaoResponse;
import com.example.segundos_api.model.Questao;
import com.example.segundos_api.service.QuestaoService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.tags.Tag;



@RestController
@RequestMapping("/api/questao")
@Tag(name = "Questões")
public class QuestaoController {

    private final QuestaoService questaoService;

    public QuestaoController(QuestaoService questaoService) {
        this.questaoService = questaoService;
    }

    @PostMapping("RegistrarQuestoes")
    @ResponseStatus(HttpStatus.CREATED)
    public QuestaoResponse createQuestao(@RequestBody QuestaoRequest questaoRequest) {
        Questao createdQuestao = questaoService.createQuestao(questaoRequest);
        return QuestaoMapper.toResponse(createdQuestao);
    }

    @GetMapping("ListarRegistroQuestoes")
    @ResponseStatus(HttpStatus.OK)
    public List<QuestaoResponse> getAllQuestoes() {
        List<Questao> questoes = questaoService.getAllQuestoes();
        return questoes.stream()
                       .map(QuestaoMapper::toResponse)
                       .collect(Collectors.toList());
    }

    @GetMapping("QuestoesPorID/{id}")
    @ResponseStatus(HttpStatus.OK)
    public QuestaoResponse getQuestaoById(@PathVariable Long id) {
        Questao questao = questaoService.getQuestaoById(id);
        return QuestaoMapper.toResponse(questao);
    }

    @GetMapping("QuestoesPorMateria/{idMateria}")
    @ResponseStatus(HttpStatus.OK)
    public List<QuestaoResponse> getQuestoesByMateria(@PathVariable Long idMateria) {
        List<Questao> questoes = questaoService.getQuestoesByIdMateria(idMateria);
        return questoes.stream()
                       .map(QuestaoMapper::toResponse)
                       .collect(Collectors.toList());
    }

    @GetMapping("QuestoesPorAssunto/{idAssunto}")
    @ResponseStatus(HttpStatus.OK)
    public List<QuestaoResponse> getQuestoesByAssunto(@PathVariable Long idAssunto) {
        List<Questao> questoes = questaoService.getQuestoesByIdAssunto(idAssunto);
        return questoes.stream()
                       .map(QuestaoMapper::toResponse)
                       .collect(Collectors.toList());
    }
    
}
