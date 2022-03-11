package com.apicontatos.apicontatos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apicontatos.apicontatos.entities.Contato;
import com.apicontatos.apicontatos.services.ContatoService;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;
	
	@GetMapping
	public ResponseEntity<List<Contato>> findAll() {
		List<Contato> list = contatoService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody Contato obj) {
		if(contatoService.existsByTelefoneAndCelular(obj.getTelefone(), obj.getCelular())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Contato ja existe");
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.insert(obj));
	}
	
}
