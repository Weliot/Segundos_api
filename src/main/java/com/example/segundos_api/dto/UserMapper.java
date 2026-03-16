package com.example.segundos_api.dto;

import com.example.segundos_api.dto.response.UserResponse;
import com.example.segundos_api.model.User;

public class UserMapper {
    
    public static UserResponse toResponse(User user) {
        return new UserResponse(
            user.getIdUsuario(),
            user.getNomeUsuario(),
            user.getEmailUsuario()
        );
    }
}