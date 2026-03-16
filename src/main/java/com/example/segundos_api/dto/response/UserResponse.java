package com.example.segundos_api.dto.response;

import com.example.segundos_api.model.User;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "UserResponse", description = "DTO de resposta para usuário")
public record UserResponse(
    
    @Schema(
        description = "ID do usuário",
        example = "idUsuario: 0"
    )
    Long idUsuario,

    @Schema(
        description = "Nome do usuário",
        example = "nomeUsuario: 'João' "
    )
    String nomeUsuario,

    @Schema(
        description = "E-mail do usuário",
        example = "emailUsuario: 'joao@joao.com' "
    )
    String emailUsuario
) {
    
    // Método estático para conversão de entidade para DTO
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
            user.getIdUsuario(),
            user.getNomeUsuario(),
            user.getEmailUsuario()
        );
    }
}