package com.example.segundos_api.controller;

import com.example.segundos_api.dto.AssuntoMapper;
import com.example.segundos_api.dto.request.AssuntoRequest;
import com.example.segundos_api.dto.response.AssuntoResponse;
import com.example.segundos_api.model.Assunto;
import com.example.segundos_api.service.AssuntoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/api/assunto")
@Tag(name = "Assuntos", description = "Operações de controle de assuntos")
public class AssuntoController {

    private final AssuntoService assuntoService;

    public AssuntoController(AssuntoService assuntoService) {
        this.assuntoService = assuntoService;
    }

    @PostMapping("CadastrarAssunto")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
        summary = "Cadastrar novo assunto",
        description = "Endpoint para criação de um novo assunto utilizando o nome do assunto e o id da matéria"
    )
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Assunto criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida, verifique os dados enviados"),
        @ApiResponse(responseCode = "404", description = "Recurso não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public AssuntoResponse createAssunto(@RequestBody AssuntoRequest assuntoRequest) {
        Assunto createdAssunto = assuntoService.createAssunto(assuntoRequest);
        return AssuntoMapper.toResponse(createdAssunto);
    }

    @GetMapping("ListarAssuntos")
    public List<AssuntoResponse> getAllAssuntos() {
        return assuntoService.getAllAssuntos().stream()
                .map(AssuntoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("AssuntosPorId/{idAssunto}")
    public AssuntoResponse getAssuntoById(@PathVariable Long idAssunto) {
        Assunto assunto = assuntoService.getAssuntoById(idAssunto);
        return AssuntoMapper.toResponse(assunto);
    }

    @GetMapping("AssuntosPorIdMateria/{idMateria}")
    public List<AssuntoResponse> getAssuntosByIdMateria(@PathVariable Long idMateria) {
        return assuntoService.getAssuntoByIdMateria(idMateria).stream()
                .map(AssuntoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @PutMapping("AtualizarAssunto/{idAssunto}")
    public AssuntoResponse updateAssunto(@PathVariable Long idAssunto, @RequestBody String nomeAssunto) {

        String nomeAssuntoLimpo = nomeAssunto.replaceAll("^\"|\"$", "").replace("\\\"", "\"");

        Assunto updatedAssunto = assuntoService.updateAssunto(idAssunto, nomeAssuntoLimpo);
        return AssuntoMapper.toResponse(updatedAssunto);
    }

    @DeleteMapping("DeletarAssunto/{idAssunto}")
    public AssuntoResponse deleteAssunto(@PathVariable Long idAssunto) {
        Assunto deletedAssunto = assuntoService.deleteAssunto(idAssunto);
        return AssuntoMapper.toResponse(deletedAssunto);
    } 
    
}
