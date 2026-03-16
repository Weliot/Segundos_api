package com.example.segundos_api.service;

import com.example.segundos_api.dto.request.MateriaRequest;
import com.example.segundos_api.model.Materia;
import java.util.List;

public interface MateriaService {
    Materia createMateria(MateriaRequest materiaRequest);
    List<Materia> getAllMaterias();
    Materia getMateriaById(Long idMateria);
    List<Materia> getMateriaByIdUsuario(Long idUsuario);
    Materia deleteMateria(Long idMateria);
    Materia updateMateria(Long idMateria, String nomeMateria);
}