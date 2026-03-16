package com.example.segundos_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.segundos_api.model.User;

public interface AcessoRepository extends JpaRepository<User, Long> {

    User findByEmailUsuario(String emailUsuario);
    
}