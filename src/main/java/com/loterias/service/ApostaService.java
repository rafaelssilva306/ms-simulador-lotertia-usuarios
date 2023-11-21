package com.loterias.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loterias.model.Aposta;
import com.loterias.model.Usuario;
import com.loterias.repository.ApostaRepository;
import com.loterias.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class ApostaService {
	
	@Autowired
	private ApostaRepository repository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public List<Aposta> findAll() {
		return repository.findAll();
	}
	
	 public Aposta cadastrarApostas(Aposta aposta) {
	        Integer idUsuario = aposta.getUsuario().getId();
	        
	        Usuario usuario = usuarioRepository.findById(idUsuario)
	                                          .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
	        
	        usuario.getNome();

	        Aposta novaAposta = new Aposta();
	        novaAposta.setUsuario(usuario);
	        novaAposta.setNumeroAposta(aposta.getNumeroAposta());

	        return repository.save(novaAposta);
	    }
}
