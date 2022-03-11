package com.apicontatos.apicontatos.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apicontatos.apicontatos.entities.Empresa;
import com.apicontatos.apicontatos.repositories.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository contatoRepository;
	
	public List<Empresa> findAll() {
		return contatoRepository.findAll();
	}
	
	@Transactional
	public Empresa insert(Empresa obj) {
		return contatoRepository.save(obj);
	}

	
}
