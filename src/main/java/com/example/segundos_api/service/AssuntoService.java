package com.example.segundos_api.service;

import java.util.List;

import com.example.segundos_api.dto.request.AssuntoRequest;
import com.example.segundos_api.model.Assunto;

public interface AssuntoService {
    
    Assunto createAssunto(AssuntoRequest assunto);
    List<Assunto> getAllAssuntos();
    Assunto getAssuntoById(Long idAssunto);
    List<Assunto> getAssuntoByIdMateria(Long idMateria);
    Assunto updateAssunto(Long idAssunto, String nomeAssunto);
    Assunto deleteAssunto(Long idAssunto);
}