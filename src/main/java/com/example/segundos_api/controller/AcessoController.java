package com.example.segundos_api.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.segundos_api.dto.request.AcessoRequest;
import com.example.segundos_api.dto.response.AcessoResponse;
import com.example.segundos_api.service.AcessoService;


@RestController
@RequestMapping("api/autorizacao")
public class AcessoController {

    private final AcessoService acessoService;

    public AcessoController(AcessoService acessoService) {
        this.acessoService = acessoService;
    }

    @PostMapping("autorizar")
    public AcessoResponse autorizarUsuario(@RequestBody AcessoRequest acessoRequest) {
   
        boolean autorizacao = acessoService.validarUsuario(acessoRequest);
        
        if (!autorizacao) {
            throw new RuntimeException("Acesso não autorizado para o usuário: " + acessoRequest.emailUsuario());            
        }
        
        return acessoService.acessoAutorizado(autorizacao, acessoRequest);
    }
    
}
