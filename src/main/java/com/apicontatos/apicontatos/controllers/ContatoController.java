package com.apicontatos.apicontatos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public ResponseEntity<Page<Contato>> findAll(Pageable pageable) {
		Page<Contato> result = contatoService.findAll(pageable);
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Contato> findById(@PathVariable Long id) {
		Contato obj = contatoService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Object> insert(@RequestBody Contato obj) {
		if(contatoService.existsByTelefoneAndCelular(obj.getTelefone(), obj.getCelular())) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Contato ja existe");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.insert(obj));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Contato> update(@PathVariable Long id, Contato obj) {
		obj = contatoService.update(id, obj);
		return ResponseEntity.status(HttpStatus.OK).body(obj);
	}
	
}
