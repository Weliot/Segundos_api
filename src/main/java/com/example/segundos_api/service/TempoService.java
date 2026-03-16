package com.example.segundos_api.service;

import java.util.List;

import com.example.segundos_api.dto.request.TempoRequest;
import com.example.segundos_api.model.Tempo;

public interface TempoService {

    Tempo createTempo(TempoRequest tempoRequest);
    Tempo getTempoById(Long idTempo);
    List<Tempo> getAllTempos();
    List<Tempo> getTemposByIdMateria(Long idMateria);
    List<Tempo> getTemposByIdAssunto(Long idAssunto);
    Long getTotalTempoEstudoByIdMateria(Long idMateria);
    Long getTotalTempoEstudoByIdAssunto(Long idAssunto);
    
}
