package com.example.segundos_api.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tsec_tempos")
public class Tempo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tempo")
    private Long idTempo;

    @Column(name = "tempo_estudo", nullable = false)
    private Long tempoEstudo;

    @Column(name = "id_assunto", nullable = false)
    private Long idAssunto;

    @Column(name = "id_materia", nullable = false)
    private Long idMateria;

    @Column(name = "data_registro",
            nullable = false,
            insertable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP")
    private LocalDateTime dataRegistro;

    //Getters e Setters

    public Long getIdTempo () {
        return idTempo;
    }

    public Long getTempoEstudo (){
        return tempoEstudo;
    }

    public Long getIdMateria (){
        return idMateria;
    }

    public Long getIdAssunto (){
        return idAssunto;
    }

    public LocalDateTime getDataRegistro (){
        return dataRegistro;
    }

    public void setTempoEstudo (Long tempoEstudo){
        this.tempoEstudo = tempoEstudo;
    }

    public void setIdMateria (Long idMateria){
        this.idMateria = idMateria;
    }

    public void setIdAssunto (Long idAssunto){
        this.idAssunto = idAssunto;
    }
}
