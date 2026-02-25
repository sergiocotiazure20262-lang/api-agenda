package br.com.cotiinformatica.api_agenda.runners;

import br.com.cotiinformatica.api_agenda.entities.Categoria;
import br.com.cotiinformatica.api_agenda.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class DatabaseRunner implements ApplicationRunner {

    //Injeção de dependência
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Definindo os nomes das categorias
        var categorias = new String[] { "Família", "Trabalho", "Estudo", "Lazer", "Saúde", "Viagens", "Outros" };

        //Cadastrar as categorias
        for(var nome : categorias) {

            if( ! categoriaRepository.exists(nome)) {
                var categoria = new Categoria();
                categoria.setNome(nome);

                categoriaRepository.save(categoria);
            }
        }
    }
}
