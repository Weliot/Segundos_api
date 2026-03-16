package com.example.segundos_api.controller;

import com.example.segundos_api.dto.request.MateriaRequest;
import com.example.segundos_api.dto.response.MateriaResponse;
import com.example.segundos_api.model.Materia;
import com.example.segundos_api.service.MateriaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.segundos_api.dto.MateriaMapper;

import java.util.stream.Collectors;

import java.util.List;

@RestController
@RequestMapping("/api/materia")
@Tag(name = "Materias")
public class MateriaController {
    
    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @PostMapping("CadastrarMateria")
    @ResponseStatus(HttpStatus.CREATED)
    public MateriaResponse createMateria(@RequestBody MateriaRequest materiaRequest) {
        Materia createdMateria = materiaService.createMateria(materiaRequest);
        return MateriaMapper.toResponse(createdMateria);
    }

    @GetMapping("ListarMaterias")
    public List<MateriaResponse> getAllMaterias() {
        return materiaService.getAllMaterias().stream()
                .map(MateriaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @GetMapping("MateriasPorId/{idMateria}")
    public MateriaResponse getMateriaById(@PathVariable Long idMateria) {
        Materia materia = materiaService.getMateriaById(idMateria);
        return MateriaMapper.toResponse(materia);
    }

    @GetMapping("MateriasPorIdUsuario/{idUsuario}")
    public List<MateriaResponse> getMateriaByIdUsuario(@PathVariable Long idUsuario) {
        return materiaService.getMateriaByIdUsuario(idUsuario).stream()
                .map(MateriaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @DeleteMapping("DeletarMateria/{idMateria}")
    public MateriaResponse deleteMateria(@PathVariable Long idMateria) {
        Materia deletedMateria = materiaService.deleteMateria(idMateria);
        return MateriaMapper.toResponse(deletedMateria);
    }

    @PutMapping("AtualizarMateria/{idMateria}")
    public MateriaResponse updateMateria(@PathVariable Long idMateria, @RequestBody String nomeMateria) {

        String nomeMateriaLimpo = nomeMateria.replaceAll("^\"|\"$", "").replace("\\\"", "\"");

        Materia updatedMateria = materiaService.updateMateria(idMateria, nomeMateriaLimpo);
        return MateriaMapper.toResponse(updatedMateria);
    }
}