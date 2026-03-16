package com.example.segundos_api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")  // Ativa o perfil de teste
class SegundosApiApplicationTests {


    @Test
    void contextLoads() {
        // Teste vazio para verificar carga do contexto
    }
}