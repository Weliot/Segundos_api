package com.example.segundos_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tsec_questoes")
public class Questao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_questoes")
    private Long idQuestoes;

    @Column(name = "qtd_questoes", nullable = false)
    private Long qtdQuestoes;

    @Column(name = "qtd_acertos", nullable = false)
    private Long qtdAcertos;

    @Column(name = "qtd_erros", nullable = false)
    private Long qtdErros;

    @Column(name = "id_assunto", nullable = false)
    private Long idAssunto;

    @Column(name = "id_materia", nullable = false)
    private Long idMateria;

    @Column(name = "id_usuario", nullable = false)
    private Long idUsuario;

    @Column(name = "data_registro",
            nullable = false,
            insertable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP")
    private LocalDateTime dataRegistro;
    
    // Getters e Setters

    public Long getIdQuestoes() {
        return idQuestoes;
    }

    public Long getQtdQuestoes() {
        return qtdQuestoes;
    }

    public Long getQtdAcertos() {
        return qtdAcertos;
    }

    public Long getQtdErros() {
        return qtdErros;
    }

    public Long getIdAssunto() {
        return idAssunto;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setQtdQuestoes(Long qtdQuestoes) {
        this.qtdQuestoes = qtdQuestoes;
    }

    public void setQtdAcertos(Long qtdAcertos) {
        this.qtdAcertos = qtdAcertos;
    }

    public void setQtdErros(Long qtdErros) {
        this.qtdErros = qtdErros;
    }

    public void setIdAssunto(Long idAssunto) {
        this.idAssunto = idAssunto;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    
}
