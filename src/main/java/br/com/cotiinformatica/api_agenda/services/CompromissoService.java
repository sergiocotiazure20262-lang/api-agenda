package br.com.cotiinformatica.api_agenda.services;

import br.com.cotiinformatica.api_agenda.dtos.CategoriaResponse;
import br.com.cotiinformatica.api_agenda.dtos.CompromissoRequest;
import br.com.cotiinformatica.api_agenda.dtos.CompromissoResponse;
import br.com.cotiinformatica.api_agenda.entities.Compromisso;
import br.com.cotiinformatica.api_agenda.enums.Prioridade;
import br.com.cotiinformatica.api_agenda.repositories.CategoriaRepository;
import br.com.cotiinformatica.api_agenda.repositories.CompromissoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CompromissoService {

    @Autowired
    private CompromissoRepository compromissoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    /*
        Método para realizar o cadastro de um compromisso
     */
    public CompromissoResponse cadastrar(CompromissoRequest request) {

        //Consultar a categoria no banco de dados attravés do ID
        var categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada."));

        //Copiar os dados do compromisso
        var compromisso = modelMapper.map(request, Compromisso.class);
        compromisso.setId(null); //garantindo que o ID será gerado no banco de dados
        compromisso.setCategoria(categoria); //associar a categoria do compromisso
        compromisso.setUsuarioId(UUID.randomUUID()); //provisório

        //Salvar no banco de dados
        compromissoRepository.save(compromisso);

        //Retornar os dados do response
        return modelMapper.map(compromisso, CompromissoResponse.class);
    }

    /*
        Método para atualizar um compromisso
     */
    public CompromissoResponse atualizar(UUID id, CompromissoRequest request) {

        //Consultar o compromisso através do ID
        var compromisso = compromissoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Compromisso não encontrado."));

        //Consultar a categoria no banco de dados attravés do ID
        var categoria = categoriaRepository.findById(request.getCategoriaId())
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada."));

        //Alterar os dados do compromisso
        compromisso.setTitulo(request.getTitulo());
        compromisso.setDataHora(request.getDataHora());
        compromisso.setPrioridade(Prioridade.valueOf(request.getPrioridade()));
        compromisso.setCategoria(categoria);

        //Salvar no banco de dados
        compromissoRepository.save(compromisso);

        //Retornar os dados do response
        return modelMapper.map(compromisso, CompromissoResponse.class);
    }

    /*
        Método para excluir um compromisso
    */
    public CompromissoResponse excluir(UUID id) {

        //Consultar o compromisso através do ID
        var compromisso = compromissoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Compromisso não encontrado."));

        //Excluir no banco de dados
        compromissoRepository.delete(compromisso);

        //Retornar os dados do response
        return modelMapper.map(compromisso, CompromissoResponse.class);
    }

    /*
        Método para consultar todos os compromissos
     */
    public List<CompromissoResponse> obterTodos() {

        //Consultar os compromissos no banco de dados
        var compromissos = compromissoRepository.findAll();

        //Criando uma lista do DTO (Response)
        var response = new ArrayList<CompromissoResponse>();

        //Coopiar os dados de cada compromisso para o DTO de resposta
        for(var c : compromissos)
            response.add(modelMapper.map(c, CompromissoResponse.class));

        //Retornar a lista
        return response;
    }
}
