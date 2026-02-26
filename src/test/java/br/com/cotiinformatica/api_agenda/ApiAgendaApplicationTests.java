package br.com.cotiinformatica.api_agenda;

import br.com.cotiinformatica.api_agenda.dtos.CategoriaResponse;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApiAgendaApplicationTests {

	/*

	//Injeção de dependência
	@Autowired
	private MockMvc mockMvc;

	//Injeção de dependência
	@Autowired
	private ObjectMapper mapper;

	@Test
	@Order(1)
	void consultarCategoriasTest() throws Exception{

		//Fazendo uma requisição HTTP GET para consultar categorias na API
		var result = mockMvc.perform(get("/api/v1/categorias"))
				.andExpect(status().isOk()) //aguardando resposta de sucesso (HTTP 200)
				.andReturn(); //capturando o JSON da resposta

		//Capturar o conteudo JSON retornado pela API
		var json = result.getResponse().getContentAsString();
		//Deserializar o JSON, transformando-o na classe DTO
		var response = mapper.readValue(json, new TypeReference<List<CategoriaResponse>>() {});

		//Verificar se a lista não está nula (vazia)
		assertNotNull(response);

		//Verificar se a lista tem pelo menos 1 objeto
		assertTrue(response.size() > 0);
	}

	@Test
	@Order(2)
	void cadastrarCompromissoTest() {
		fail("Não implementado!");
	}

	@Test
	@Order(3)
	void atualizarCompromissoTest() {
		fail("Não implementado!");
	}

	@Test
	@Order(4)
	void excluirCompromissoTest() {
		fail("Não implementado!");
	}

	@Test
	@Order(5)
	void consultarCompromissosTest() {
		fail("Não implementado!");
	}

	*/
}
