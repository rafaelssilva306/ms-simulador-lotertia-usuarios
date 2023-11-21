package com.loterias.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "apostas") 
public class Aposta implements Serializable {

	private static final long serialVersionUID = 7153049524620172802L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
	
	@Column(name = "numeros_apostados")
	private String numeroAposta;
	
	public Aposta() {
	}

	public Aposta(Integer id, Usuario usuario, String numeroAposta) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.numeroAposta = numeroAposta;
	}

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNumeroAposta() {
		return numeroAposta;
	}

	public void setNumeroAposta(String numeroAposta) {
		this.numeroAposta = numeroAposta;
	}
}
