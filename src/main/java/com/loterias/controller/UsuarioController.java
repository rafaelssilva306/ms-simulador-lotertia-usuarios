package com.loterias.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.loterias.model.Usuario;
import com.loterias.service.UsuarioService;

@RestController
@RequestMapping(value = "/loterias/admin")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = usuarioService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping("/buscarPorLogin")
	public ResponseEntity<?> buscarPorLogin(@RequestBody Map<String, String> requestBody) {
		String login = requestBody.get("login");
		Optional<Usuario> usuario = usuarioService.buscarPorLogin(login);

		if (usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado para o login fornecido");
		}
	}

	@GetMapping("/buscaporid/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Optional<Usuario> usuario = usuarioService.buscarPorId(id);

		if (usuario.isPresent()) {
			return ResponseEntity.ok(usuario.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado para o ID fornecido");
		}
	}

	@PostMapping("/criarusuario")
	public ResponseEntity<?> criarUsuario(@RequestBody Usuario usuario) {
		Usuario novoUsuario = usuarioService.criarUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
	}

	@DeleteMapping("/apagarusuario/{id}")
	public ResponseEntity<?> deletarUsuario(@PathVariable Integer id) {
		usuarioService.deletarUsuarioPorId(id);
		return ResponseEntity.ok("Usuário excluído com sucesso");
	}

}
