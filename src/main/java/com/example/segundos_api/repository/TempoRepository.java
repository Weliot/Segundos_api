package com.example.segundos_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.segundos_api.model.Tempo;

public interface TempoRepository extends JpaRepository<Tempo, Long> {

    List<Tempo> findByIdMateria(Long idMateria);
    List<Tempo> findByIdAssunto(Long idAssunto);
    Long countByIdMateria(Long idMateria);
    Long countByIdAssunto(Long idAssunto);
    
}
