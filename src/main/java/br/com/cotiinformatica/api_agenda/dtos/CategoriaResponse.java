package br.com.cotiinformatica.api_agenda.dtos;

import lombok.Data;

import java.util.UUID;

/*
    Record DTO para retornar os dados
    da consulta de categorias na API.
 */
@Data
public class CategoriaResponse {

    private UUID id;
    private String nome;
}
