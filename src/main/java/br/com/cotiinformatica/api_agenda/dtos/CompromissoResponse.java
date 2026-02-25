package br.com.cotiinformatica.api_agenda.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class CompromissoResponse {

    private UUID id;
    private String titulo;
    private LocalDateTime dataHora;
    private String prioridade;
    private CategoriaResponse categoria;
}
