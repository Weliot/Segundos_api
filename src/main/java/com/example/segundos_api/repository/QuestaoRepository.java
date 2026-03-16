package com.example.segundos_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.segundos_api.model.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

    List<Questao> findByIdMateria(Long idMateria);
    List<Questao> findByIdAssunto(Long idAssunto);
    
}