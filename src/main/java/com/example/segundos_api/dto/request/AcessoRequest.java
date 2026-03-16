package com.example.segundos_api.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(name = "AcessoRequest", description = "DTO de requisição de acesso")
public record AcessoRequest(
    
    @Schema(name = "emailUsuario", example = "email@email.com")
    @NotBlank(message = "Email do usuário deve ser preenchido")
    String emailUsuario,
    
    @Schema(name = "passwordUsuario", example = "senha123")
    @NotBlank(message = "Senha do usuário deve ser preenchida")
    String passwordUsuario

){}