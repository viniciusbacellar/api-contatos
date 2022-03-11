package com.apicontatos.apicontatos.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicontatos.apicontatos.entities.Contato;
import com.apicontatos.apicontatos.repositories.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public List<Contato> findAll() {
		return contatoRepository.findAll();
	}
	
	@Transactional
	public Contato insert(Contato obj) {
		return contatoRepository.save(obj);
	}
	
	public Boolean existsByTelefoneAndCelular(String telefone, String celular) {
		return contatoRepository.existsByTelefoneAndCelular(telefone, celular);
	}

	
}
