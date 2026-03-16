package com.example.segundos_api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.segundos_api.dto.request.MateriaRequest;
import com.example.segundos_api.model.Materia;
import com.example.segundos_api.repository.MateriaRepository;
import com.example.segundos_api.service.MateriaService;

@Service
public class MateriaServiceImpl implements MateriaService {

    private final MateriaRepository materiaRepository;

    public MateriaServiceImpl(MateriaRepository userRepository) {
        this.materiaRepository = userRepository;
    }

    @Override
    public Materia createMateria(MateriaRequest materiaRequest) {
        Materia materia = new Materia();
        materia.setNomeMateria(materiaRequest.nomeMateria());
        materia.setIdUsuario(materiaRequest.idUsuario());
        
        return materiaRepository.save(materia);
    }


    @SuppressWarnings("null")
    @Override
    public Materia getMateriaById(Long idMateria) {
        // Your logic here (e.g., fetch user from database)
        return materiaRepository.findById(idMateria).orElse(null);
    }

    @Override
    public List<Materia> getMateriaByIdUsuario(Long idUsuario) {
        // Your logic here (e.g., fetch user from database)
        return materiaRepository.findMateriaByIdUsuario(idUsuario);
    }

    @Override
    public List<Materia> getAllMaterias() {
        // Your logic here (e.g., fetch all users from database)
        return materiaRepository.findAll();
    }

    @Override
    public Materia deleteMateria(Long idMateria) {
        Materia materia = getMateriaById(idMateria);
        if (materia != null) {
            materiaRepository.delete(materia);
        }
        return materia;
    }
    
    @Override
    public Materia updateMateria(Long idMateria, String nomeMateria) {
        Materia materia = getMateriaById(idMateria);
        if (materia != null) {
            materia.setNomeMateria(nomeMateria);
            return materiaRepository.save(materia);
        }
        return null; // or throw an exception if preferred
    }
    // Outros métodos atualizados conforme necessário
}