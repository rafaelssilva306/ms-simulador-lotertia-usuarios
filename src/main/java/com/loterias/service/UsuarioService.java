package com.loterias.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loterias.model.Usuario;
import com.loterias.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public Optional<Usuario> buscarPorId(Long id) {
		return repository.findById(id);
	}

	public Optional<Usuario> buscarPorLogin(String login) {
		return repository.findByLogin(login);
	}
	
	public Usuario criarUsuario(Usuario usuario) {
        return repository.save(usuario);
    }
	
	public void deletarUsuarioPorId(Integer id) {
		repository.deleteById(id);
    }

}
