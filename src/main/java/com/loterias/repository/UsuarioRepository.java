package com.loterias.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loterias.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	 Optional<Usuario> findByLogin(String login);
	 
	 List<Usuario> findAll();
	 
	 Optional<Usuario> findById(Long id);

}
