package br.com.cotiinformatica.api_agenda.entities;

import br.com.cotiinformatica.api_agenda.enums.Prioridade;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "compromissos")
@Data
public class Compromisso {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "data_hora", nullable = false)
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "prioridade", nullable = false)
    private Prioridade prioridade;

    @Column(name = "usuario_id", nullable = false)
    private UUID usuarioId;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;
}
