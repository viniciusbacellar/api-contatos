package com.apicontatos.apicontatos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apicontatos.apicontatos.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
	Boolean existsByTelefoneAndCelular(String telefone, String celular);
}
