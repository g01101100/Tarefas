package com.g01101100.Tarefas.service;

import com.g01101100.Tarefas.dtos.*;
import com.g01101100.Tarefas.models.Tarefa;
import com.g01101100.Tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService{

    @Autowired
    private TarefaRepository repository;

    public ResponseTarefaDto criarTarefa(CreateTarefaDto dto){
        if(dto.titulo() == null || dto.titulo().length() < 3){
            throw new IllegalArgumentException("O título deve ter pelo menos de 3 caracteres!");
        }
        Tarefa novaTarefa = new Tarefa(dto.titulo());

        repository.save(novaTarefa);

        return new ResponseTarefaDto(novaTarefa);

    }


    public void excluirTarefaPeloId(DeleteTarefaDto dto){
        if(!repository.existsById(dto.Id())) {
            throw new IllegalArgumentException("Essa Tarefa não existe");
        }
        repository.deleteById(dto.Id());
    }


    public ResponseTarefaDto atualizaTarefaPorIDComNovoTitulo(UpdateTituloTarefaDto dto){
        Tarefa tarefaExistente = repository.findById(dto.Id())
                .orElseThrow(() -> new IllegalArgumentException("A tarefa referente a esse Id não existe."));

        tarefaExistente.trocarTitulo(dto.novoTitulo());

        Tarefa tarefaAtualizada = repository.save(tarefaExistente);

        return new ResponseTarefaDto(tarefaAtualizada);

    }
    public ResponseTarefaDto atualizaStatusTarefaPorID(UpdateStatusTarefaDto dto){
        Tarefa tarefaExistente = repository.findById(dto.Id())
                .orElseThrow(() -> new IllegalArgumentException("A tarefa referente a esse Id não existe."));

        tarefaExistente.atualizaStatus();

        Tarefa tarefaAtualizada = repository.save(tarefaExistente);

        return new ResponseTarefaDto(tarefaAtualizada);

    }

    public List<Tarefa> buscaTodasAsTarefas(){
        return repository.findAll();
    }

    public List<Tarefa> buscaTodasAsTarefasConcluidas(){
        return repository.findByConcluidaTrue();
    }

    public List<Tarefa> buscaTodasAsTarefasPendentes(){
        return repository.findByConcluidaFalse();
    }


}
