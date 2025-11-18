package com.g01101100.Tarefas.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DeleteTarefaDto (
        @NotNull(message = "O ID é obrigatório")
        @Positive(message = "O ID precisa ser positivo")
        Long Id
){}
