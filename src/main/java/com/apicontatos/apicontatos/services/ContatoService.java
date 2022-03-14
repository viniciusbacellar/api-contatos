package com.apicontatos.apicontatos.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.apicontatos.apicontatos.entities.Contato;
import com.apicontatos.apicontatos.repositories.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	
	public Page<Contato> findAll(Pageable pageable) {
		Page<Contato> result = contatoRepository.findAll(pageable);
		return result;
	}
	
	public Contato findById(Long id) {
		Optional<Contato> obj = contatoRepository.findById(id);
		return obj.get();
	}
	
	@Transactional
	public Contato insert(Contato obj) {
		return contatoRepository.save(obj);
	}
	
	public Boolean existsByTelefoneAndCelular(String telefone, String celular) {
		return contatoRepository.existsByTelefoneAndCelular(telefone, celular);
	}
	
	
	@SuppressWarnings("deprecation")
	@Transactional
	public Contato update(Long id, Contato obj) {
		Contato entity = contatoRepository.getOne(id);
		updateData(entity, obj);
		return contatoRepository.save(entity);
		
	}
	private void updateData(Contato entity, Contato obj) {
		entity.setNome(obj.getNome());
		entity.setSobrenome(obj.getSobrenome());
		entity.setDataNascimento(obj.getDataNascimento());
		entity.setTelefone(obj.getTelefone());
		entity.setCelular(obj.getCelular());
		entity.setEmail(obj.getEmail());
	}
	
}
