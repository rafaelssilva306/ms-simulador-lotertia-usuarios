package com.loterias.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.loterias.model.Aposta;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApostaControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testFindAllApostas() {
		ResponseEntity<List<Aposta>> response = restTemplate.exchange("/apostas", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Aposta>>() {
				});

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		// Faça outras asserções conforme necessário
	}

	@Test
	public void testCadastrarApostas() {
		Aposta novaAposta = new Aposta();
		// Defina os atributos da nova aposta conforme necessário para o teste

		ResponseEntity<Aposta> response = restTemplate.postForEntity("/cadastrarAposta", novaAposta, Aposta.class);

		assertEquals(HttpStatus.CREATED, response.getStatusCode());
		assertNotNull(response.getBody());
		// Faça outras asserções conforme necessário
	}
}
