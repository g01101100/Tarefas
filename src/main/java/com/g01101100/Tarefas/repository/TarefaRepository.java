package com.g01101100.Tarefas.repository;

import com.g01101100.Tarefas.models.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    List<Tarefa> findByConcluidaTrue();

    List<Tarefa> findByConcluidaFalse();
}
