package com.g01101100.Tarefas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titulo;
    private boolean concluida = false;
    private String dataDeCriacao = LocalDate.now().toString();


    public Tarefa(String titulo) {
        this.titulo = titulo;
    }

    public Tarefa() {
    }



    public Long getId() {
        return Id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void trocarTitulo(String novoTitulo){
        this.titulo = novoTitulo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void atualizaStatus(){
        this.concluida = !this.concluida;
    }


}
