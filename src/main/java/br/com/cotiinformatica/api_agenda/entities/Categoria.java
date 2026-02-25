package br.com.cotiinformatica.api_agenda.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categorias")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "nome", length = 25, nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Compromisso> compromissos;
}