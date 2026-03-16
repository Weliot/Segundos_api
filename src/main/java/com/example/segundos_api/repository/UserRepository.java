package com.example.segundos_api.repository;

import com.example.segundos_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // Método para buscar por email (usando o nome da coluna correto)
    User findByEmailUsuario(String emailUsuario);
    
}