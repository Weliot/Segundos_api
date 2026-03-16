package com.example.segundos_api.dto.request;

import jakarta.validation.constraints.NotBlank;

public record MateriaRequest(

    @NotBlank(message = "Nome é obrigatório")
    String nomeMateria,
    
    @NotBlank(message = "ID do usuário é obrigatório")
    Long idUsuario

) {}