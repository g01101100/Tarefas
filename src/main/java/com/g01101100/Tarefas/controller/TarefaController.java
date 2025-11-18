package com.g01101100.Tarefas.controller;


import com.g01101100.Tarefas.dtos.*;
import com.g01101100.Tarefas.models.Tarefa;
import com.g01101100.Tarefas.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService service;


    @GetMapping
    public List<Tarefa> listarTodasAsTarefas(){
        return service.buscaTodasAsTarefas();
    }

    @GetMapping("/concluidas")
    public List<Tarefa> listarTodasAsTarefasConcluidas(){
        return service.buscaTodasAsTarefasConcluidas();
    }

    @GetMapping("/pendentes")
    public List<Tarefa> listarTodasAsTarefasPendentes(){
        return service.buscaTodasAsTarefasPendentes();
    }


    @PostMapping
    public ResponseTarefaDto criarTarefa(@Valid @RequestBody CreateTarefaDto dto){
        return service.criarTarefa(dto);
    }


    @PutMapping("/titulo")
    public ResponseEntity<ResponseTarefaDto> atualizaTituloDaTarefa(@Valid @RequestBody UpdateTituloTarefaDto dto){
        return ResponseEntity.ok(service.atualizaTarefaPorIDComNovoTitulo(dto));
    }

    @PutMapping("/status")
    public ResponseEntity<ResponseTarefaDto> atualizaStatusDaTarefa(@Valid @RequestBody UpdateStatusTarefaDto dto){
        return ResponseEntity.ok(service.atualizaStatusTarefaPorID(dto));
    }


    @DeleteMapping()
    public ResponseEntity<Void> deletarTarefa(@Valid @RequestBody DeleteTarefaDto dto){
        service.excluirTarefaPeloId(dto);
        return ResponseEntity.noContent().build();
    }
}
