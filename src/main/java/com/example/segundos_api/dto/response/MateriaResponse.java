package com.example.segundos_api.dto.response;

import com.example.segundos_api.model.Materia;

public record MateriaResponse(
    Long idMateria,
    String nomeMateria,
    Long idUsuario
) {
    
    // Método estático para conversão de entidade para DTO
    public static MateriaResponse fromEntity(Materia materia) {
        return new MateriaResponse(
            materia.getIdMateria(),
            materia.getNomeMateria(),
            materia.getIdUsuario()
        );
    }
}