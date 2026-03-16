package com.example.segundos_api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.segundos_api.dto.request.TempoRequest;
import com.example.segundos_api.model.Tempo;
import com.example.segundos_api.repository.TempoRepository;
import com.example.segundos_api.service.TempoService;

@Service
public class TempoServiceImpl implements TempoService {

    private final TempoRepository tempoRepository;

    public TempoServiceImpl(TempoRepository tempoRepository) {
        this.tempoRepository = tempoRepository;
    }

    @Override
    public Tempo createTempo(TempoRequest tempoRequest) {
        Tempo tempo = new Tempo();

        tempo.setTempoEstudo(tempoRequest.tempoEstudo());
        tempo.setIdMateria(tempoRequest.idMateria());
        tempo.setIdAssunto(tempoRequest.idAssunto());
        
        return tempoRepository.save(tempo);
    }

    @SuppressWarnings("null")
    @Override
    public Tempo getTempoById(Long idTempo) {
        return tempoRepository.findById(idTempo).orElse(null);
    }

    @Override
    public List<Tempo> getAllTempos() {
        return tempoRepository.findAll();
    }

    @Override
    public List<Tempo> getTemposByIdMateria(Long idMateria) {
        return tempoRepository.findByIdMateria(idMateria);
    }

    @Override
    public List<Tempo> getTemposByIdAssunto(Long idAssunto) {
        return tempoRepository.findByIdAssunto(idAssunto);
    }

    @Override
    public Long getTotalTempoEstudoByIdMateria(Long idMateria) {
        return tempoRepository.countByIdMateria(idMateria);
    }

    @Override
    public Long getTotalTempoEstudoByIdAssunto(Long idAssunto) {
        return tempoRepository.countByIdAssunto(idAssunto);
    }

}