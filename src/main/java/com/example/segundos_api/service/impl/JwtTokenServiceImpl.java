package com.example.segundos_api.service.impl;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.segundos_api.model.User;
import com.example.segundos_api.service.JwtTokenService;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenServiceImpl implements JwtTokenService {

    @Value("${jwt.secret}") // Defina no application.properties
    private String jwtSecret;

    @Value("${jwt.expiration}") // Tempo em milissegundos (ex: 3600000 = 1h)
    private int jwtExpiration;

    @Override
    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpiration);
        
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        return Jwts.builder()
                .subject(("${user.getNomeUsuario()}" + "${user.getEmailUsuario()}"))
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(key)
                .compact(); // Placeholder return value
    }

    @Override
    public boolean validateToken(String token) {
        
        try {
            SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
            Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token);
            return true;

        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    @Override
    public String getUserFromToken(String token) {
        SecretKey key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        return Jwts.parser()
                .verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
    
}
