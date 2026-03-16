package com.example.segundos_api.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema (name = "AcessoResponse", description = "DTO de resposta de acesso")
public record AcessoResponse(
    
    @Schema(name = "message", example = "Acesso realizado com sucesso")
    String message,

    @Schema(name = "token", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    String token
    
) {}
