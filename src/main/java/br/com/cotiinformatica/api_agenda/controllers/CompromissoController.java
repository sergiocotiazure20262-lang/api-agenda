package br.com.cotiinformatica.api_agenda.controllers;

import br.com.cotiinformatica.api_agenda.dtos.CompromissoRequest;
import br.com.cotiinformatica.api_agenda.services.CompromissoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/compromissos")
public class CompromissoController {

    @Autowired
    private CompromissoService compromissoService;

    @PostMapping
    public ResponseEntity<?> post(@RequestBody CompromissoRequest request) {

        try {
            var response = compromissoService.cadastrar(request);
            return ResponseEntity.status(201).body(response); //CREATED
        }
        catch(IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage()); //BAD REQUEST
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body(e.getMessage()); //INTERNAL ERROR
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> put(@PathVariable UUID id, @RequestBody CompromissoRequest request) {

        try {
            var response = compromissoService.atualizar(id, request);
            return ResponseEntity.status(200).body(response); //OK
        }
        catch(IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage()); //BAD REQUEST
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body(e.getMessage()); //INTERNAL ERROR
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {

        try {
            var response = compromissoService.excluir(id);
            return ResponseEntity.status(200).body(response); //OK
        }
        catch(IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage()); //BAD REQUEST
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body(e.getMessage()); //INTERNAL ERROR
        }
    }

    @GetMapping
    public ResponseEntity<?> getAll() {

        try {
            var response = compromissoService.obterTodos();
            return ResponseEntity.status(200).body(response); //OK
        }
        catch(Exception e) {
            return ResponseEntity.status(500).body(e.getMessage()); //INTERNAL ERROR
        }
    }
}
