package com.example.segundos_api.dto;

import com.example.segundos_api.dto.response.MateriaResponse;
import com.example.segundos_api.model.Materia;

public class MateriaMapper {
    
    public static MateriaResponse toResponse(Materia materia) {
        return new MateriaResponse(
            materia.getIdMateria(),
            materia.getNomeMateria(),
            materia.getIdUsuario()
        );
    }
}
