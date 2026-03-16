package com.example.segundos_api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.segundos_api.dto.request.AssuntoRequest;
import com.example.segundos_api.model.Assunto;
import com.example.segundos_api.repository.AssuntoRepository;
import com.example.segundos_api.service.AssuntoService;

@Service
public class AssuntoServiceImpl implements AssuntoService {

    private final AssuntoRepository assuntoRepository;

    public AssuntoServiceImpl(AssuntoRepository assuntoRepository) {
        this.assuntoRepository = assuntoRepository;
    }

    @Override
    public Assunto createAssunto(AssuntoRequest assuntoRequest) {
        Assunto assunto = new Assunto();
        assunto.setNomeAssunto(assuntoRequest.nomeAssunto());
        assunto.setIdMateria(assuntoRequest.idMateria());
        
        return assuntoRepository.save(assunto);
    }

    @Override
    public List<Assunto> getAllAssuntos() {
        return assuntoRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public Assunto getAssuntoById(Long idAssunto) {
        return assuntoRepository.findById(idAssunto).orElse(null);
    }

    @Override
    public List<Assunto> getAssuntoByIdMateria(Long idMateria) {
        return assuntoRepository.findAssuntoByIdMateria(idMateria);
    }
    
    @Override
    public Assunto updateAssunto(Long idAssunto, String nomeAssunto) {
        Assunto assunto = getAssuntoById(idAssunto);
        if (assunto != null) {
            assunto.setNomeAssunto(nomeAssunto);
            return assuntoRepository.save(assunto);
        }
        return assunto;
    }
    
    @Override
    public Assunto deleteAssunto(Long idAssunto) {
        Assunto assunto = getAssuntoById(idAssunto);
        if (assunto != null) {
            assuntoRepository.delete(assunto);
            return assunto;
        }
        return null;
    }

}
