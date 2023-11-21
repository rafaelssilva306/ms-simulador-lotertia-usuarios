package com.loterias.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Collections;
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

import com.loterias.model.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsuarioControllerTest {
	
	  @Autowired
	    private TestRestTemplate restTemplate;

	    @Test
	    public void testFindAllUsuarios() {
	        ResponseEntity<List<Usuario>> response = restTemplate.exchange(
	                "/usuarios",
	                HttpMethod.GET,
	                null,
	                new ParameterizedTypeReference<List<Usuario>>() {});

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertNotNull(response.getBody());
	        // Faça outras asserções conforme necessário
	    }

	    @Test
	    public void testBuscarPorLogin() {
	        String login = "nomeDoUsuario"; // Defina o login para teste

	        ResponseEntity<Usuario> response = restTemplate.postForEntity(
	                "/buscarPorLogin",
	                Collections.singletonMap("login", login),
	                Usuario.class);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertNotNull(response.getBody());
	        // Faça outras asserções conforme necessário
	    }

	    @Test
	    public void testBuscarPorId() {
	        Long id = 1L; // Defina o ID para teste

	        ResponseEntity<Usuario> response = restTemplate.getForEntity(
	                "/buscaporid/" + id,
	                Usuario.class);

	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertNotNull(response.getBody());
	        // Faça outras asserções conforme necessário
	    }

	    @Test
	    public void testCriarUsuario() {
	        Usuario novoUsuario = new Usuario();
	        // Defina os atributos do novo usuário para teste

	        ResponseEntity<Usuario> response = restTemplate.postForEntity(
	                "/criarusuario",
	                novoUsuario,
	                Usuario.class);

	        assertEquals(HttpStatus.CREATED, response.getStatusCode());
	        assertNotNull(response.getBody());
	        // Faça outras asserções conforme necessário
	    }

	    @Test
	    public void testDeletarUsuario() {
	        Integer id = 1; // Defina o ID do usuário para exclusão

	        restTemplate.delete("/apagarusuario/" + id);

	        // Verifica se o endpoint não retorna erro
	        ResponseEntity<?> response = restTemplate.getForEntity("/buscaporid/" + id, Usuario.class);
	        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	    }

}
