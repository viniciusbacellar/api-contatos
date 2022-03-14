package com.apicontatos.apicontatos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicontatos.apicontatos.entities.Empresa;
import com.apicontatos.apicontatos.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}
	
	public Empresa findById(Long id) {
		Optional<Empresa> obj = empresaRepository.findById(id);
		return obj.get();
	}
	
	@SuppressWarnings("deprecation")
	public Empresa update(Long id, Empresa obj) {
		Empresa entity = empresaRepository.getOne(id);
		updateData(entity, obj);
		return empresaRepository.save(entity);
		
	}
	private void updateData(Empresa entity, Empresa obj) {
		entity.setNome(obj.getNome());
	}

	
}
