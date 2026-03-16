package com.example.segundos_api.service.impl;

import org.springframework.stereotype.Service;

import com.example.segundos_api.dto.request.AcessoRequest;
import com.example.segundos_api.dto.response.AcessoResponse;
import com.example.segundos_api.model.User;
import com.example.segundos_api.repository.AcessoRepository;
import com.example.segundos_api.service.AcessoService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.segundos_api.service.JwtTokenService;

@Service
public class AcessoServiceImpl implements AcessoService {

    private final AcessoRepository acessoRepository;

    private final JwtTokenService jwtTokenService;

    public static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AcessoServiceImpl(AcessoRepository acessoRepository, JwtTokenService jwtTokenService) {
        this.acessoRepository = acessoRepository;
        this.jwtTokenService = jwtTokenService;
    }

    @Override
    public User findByEmail(String emailUsuario) {

        User user = acessoRepository.findByEmailUsuario(emailUsuario);

        if (user == null) {
            throw new RuntimeException("Usuário não encontrado com o email: " + emailUsuario);
            
        }

        return user;
    }

    @Override
    public boolean validarPassword(User user, String password) {

        String passwordUsuario = user.getPasswordUsuario();
        

        return passwordEncoder.matches(password, passwordUsuario);
    }

    @Override
    public boolean validarUsuario(AcessoRequest acessoRequest) {

        User user = findByEmail(acessoRequest.emailUsuario());

        if (user != null) {
            return validarPassword(user, acessoRequest.passwordUsuario());
        }

        return false;
    }

    @Override
    public AcessoResponse acessoAutorizado(boolean validarUsuario, AcessoRequest acessoRequest) {

        User user = findByEmail(acessoRequest.emailUsuario());
        
        if (!validarUsuario) {
            throw new RuntimeException("Acesso não autorizado");
        }


        String mensage = "Acesso realizado com sucesso";
        String token =  jwtTokenService.generateToken(user);// Placeholder token
        return new AcessoResponse(mensage, token); // Placeholder return value
    }
    
}
