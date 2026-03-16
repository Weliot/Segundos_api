package com.example.segundos_api.service;

import com.example.segundos_api.dto.request.AcessoRequest;
import com.example.segundos_api.dto.response.AcessoResponse;
import com.example.segundos_api.model.User;

public interface AcessoService {

    boolean validarUsuario(AcessoRequest acessoRequest);

    AcessoResponse acessoAutorizado(boolean autorizacao, AcessoRequest acessoRequest);

    User findByEmail (String emailUsuario);

    boolean validarPassword(User user, String password);

    
}