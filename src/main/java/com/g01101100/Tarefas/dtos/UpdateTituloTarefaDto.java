package com.g01101100.Tarefas.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UpdateTituloTarefaDto(
        @NotNull(message = "O ID é obrigatório")
        @Positive(message = "O ID precisa ser positivo")
        Long Id,
        @NotBlank(message = "O título não pode estar vazio")
        @Size(min = 3, message = "O título precisa ter pelo menos 3 caracteres")
        String novoTitulo
){}
