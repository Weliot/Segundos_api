package com.example.segundos_api.dto;

import com.example.segundos_api.dto.response.TempoResponse;
import com.example.segundos_api.model.Tempo;

public class TempoMapper {
    
    public static TempoResponse toResponse(Tempo tempo){
       return new TempoResponse(
            tempo.getIdTempo(),
            tempo.getTempoEstudo(),
            tempo.getIdMateria(),
            tempo.getIdAssunto(),
            tempo.getDataRegistro()
        );
    }
}
