package com.example.segundos_api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.example.segundos_api.dto.TempoMapper;
import com.example.segundos_api.dto.request.TempoRequest;
import com.example.segundos_api.dto.response.TempoResponse;
import com.example.segundos_api.model.Tempo;
import com.example.segundos_api.service.TempoService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tempo")
@Tag(name = "Tempos")
public class TempoController {

    private final TempoService tempoService;

    public TempoController(TempoService tempoService) {
        this.tempoService = tempoService;
    }

    @PostMapping("RegistrarTempo")
    @ResponseStatus(HttpStatus.CREATED)
    public TempoResponse createTempo(@RequestBody TempoRequest tempoRequest) {
        Tempo createdTempo = tempoService.createTempo(tempoRequest);
        return TempoMapper.toResponse(createdTempo);
    }

    @GetMapping("ListarTempos")
    public List<TempoResponse> getAllTempos() {
        return tempoService.getAllTempos().stream()
                .map(TempoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("TemposPorId/{idTempo}")
    public TempoResponse getTempoById(@PathVariable Long idTempo) {
        Tempo tempo = tempoService.getTempoById(idTempo);
        return TempoMapper.toResponse(tempo);
    }

    @GetMapping("TemposPorIdMateria/{idMateria}")
    public List<TempoResponse> getTemposByIdMateria(@PathVariable Long idMateria) {
        return tempoService.getTemposByIdMateria(idMateria).stream()
                .map(TempoMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("TemposPorIdAssunto/{idAssunto}")
    public List<TempoResponse> getTemposByIdAssunto(@PathVariable Long idAssunto) {
        return tempoService.getTemposByIdAssunto(idAssunto).stream()
                .map(TempoMapper::toResponse)
                .collect(Collectors.toList());
    }
    
}
