package com.example.segundos_api.repository;

import com.example.segundos_api.model.Materia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

    // Método para buscar por email (usando o nome da coluna correto)
    List<Materia> findMateriaByIdUsuario(Long idUsuario);
    
}