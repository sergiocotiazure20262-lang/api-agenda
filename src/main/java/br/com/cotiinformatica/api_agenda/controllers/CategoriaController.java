package br.com.cotiinformatica.api_agenda.controllers;

import br.com.cotiinformatica.api_agenda.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            //Executar a consulta de categorias
            var response = categoriaService.obterTodos();
            return ResponseEntity.ok().body(response);
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
