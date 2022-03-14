package com.apicontatos.apicontatos.config;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.apicontatos.apicontatos.entities.Contato;
import com.apicontatos.apicontatos.entities.Empresa;
import com.apicontatos.apicontatos.repositories.ContatoRepository;
import com.apicontatos.apicontatos.repositories.EmpresaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
		
		Date data1 = sdf.parse("27/01/2000");
		
		Empresa e1 = new Empresa(null, "Amazon");
		Contato c1 = new Contato(null, "Vinicius", "Bacellar", data1, "33465107", "96901718132", "vinicius@gmail.com", e1);
		Contato c2 = new Contato(null, "João", "Silva", data1, "33007788", "981234673", "joao@gmail.com", e1);
		Contato c3 = new Contato(null, "Danilo", "Pinheiro", data1, "77885566", "928765453", "danilo@gmail.com", e1);
		
		
		empresaRepository.saveAll(Arrays.asList(e1));
		contatoRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		
	}

}
