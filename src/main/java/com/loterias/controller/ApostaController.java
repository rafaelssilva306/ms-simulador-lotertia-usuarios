package com.loterias.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.loterias.model.Aposta;
import com.loterias.service.ApostaService;

@Controller
@RequestMapping(value = "/loterias")
public class ApostaController {

	@Autowired
	private ApostaService service;

	@GetMapping("/apostas")
	public ResponseEntity<List<Aposta>> findAll() {
		List<Aposta> apostas = service.findAll();
		return ResponseEntity.ok().body(apostas);
	}

	@PostMapping("/cadastrarAposta")
    public ResponseEntity<?> cadastrarApostas(@RequestBody Aposta aposta) {
        try {
        	Aposta novaAposta = service.cadastrarApostas(aposta);
            return ResponseEntity.status(HttpStatus.CREATED).body(novaAposta);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
