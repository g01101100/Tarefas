package com.g01101100.Tarefas.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

public record CreateTarefaDto (
        @NotBlank(message = "O título não pode estar vazio")
        @Size(min = 3, message = "O título precisa ter pelo menos 3 caracteres")
        String titulo
){}
