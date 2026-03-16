package com.example.segundos_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.segundos_api.model.Assunto;

public interface AssuntoRepository extends JpaRepository<Assunto, Long>{

    List<Assunto> findAssuntoByIdMateria(Long idMateria);
}