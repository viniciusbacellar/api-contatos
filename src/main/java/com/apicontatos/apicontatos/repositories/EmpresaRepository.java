package com.apicontatos.apicontatos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apicontatos.apicontatos.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
}
