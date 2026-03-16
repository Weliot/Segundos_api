package com.example.segundos_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tsec_assuntos")
public class Assunto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assunto")
    private Long idAssunto;

    @Column(name = "nome_assunto", nullable = false, length = 50)
    private String nomeAssunto;

    @Column(name = "id_materia", nullable = false, length = 50)
    private Long idMateria;

    //Getters e Setters

    public Long getIdAssunto () {
        return idAssunto;
    }

    public String getNomeAssunto (){
        return nomeAssunto;
    }

    public Long getIdMateria (){
        return idMateria;
    }

    public void setNomeAssunto (String nomeAssunto){
        this.nomeAssunto = nomeAssunto;
    }

    public void setIdMateria (Long idMateria){
        this.idMateria = idMateria;
    }

}
