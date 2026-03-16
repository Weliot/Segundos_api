package com.example.segundos_api.service;

import com.example.segundos_api.model.User;

public interface JwtTokenService {
    
    String generateToken(User user);

    boolean validateToken(String token);

    String getUserFromToken(String token);
}
