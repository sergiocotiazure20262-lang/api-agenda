package br.com.cotiinformatica.api_agenda.repositories;

import br.com.cotiinformatica.api_agenda.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, UUID> {

    /*
        Consulta para verificar se uma Categoria
        existe no banco de dados pelo nome
     */
    @Query("""
                SELECT COUNT(c) > 0
                FROM Categoria c
                WHERE c.nome = :nome
            """)
    boolean exists(@Param("nome") String nome);
}
