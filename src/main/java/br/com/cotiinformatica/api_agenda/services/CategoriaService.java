package br.com.cotiinformatica.api_agenda.services;

import br.com.cotiinformatica.api_agenda.dtos.CategoriaResponse;
import br.com.cotiinformatica.api_agenda.repositories.CategoriaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    /*
        Método para retornar uma lista com
        todas as categorias do banco
     */
    public List<CategoriaResponse> obterTodos() {

        //Consultar as categorias no banco de dados
        var categorias = categoriaRepository.findAll();

        //Criando uma lista do DTO (Response)
        var response = new ArrayList<CategoriaResponse>();

        //Coopiar os dados de cada categoria para o DTO de resposta
        for(var c : categorias)
            response.add(modelMapper.map(c, CategoriaResponse.class));

        //Retornar a lista
        return response;
    }

}
