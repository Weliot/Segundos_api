package com.example.segundos_api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(

    @NotBlank(message = "Nome é obrigatório")
    String nomeUsuario,
    
    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String emailUsuario,

    @NotBlank(message = "senha é obrigatória")
    String passwordUsuario

) {}