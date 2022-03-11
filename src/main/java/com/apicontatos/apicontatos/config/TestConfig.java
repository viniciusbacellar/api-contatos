package com.apicontatos.apicontatos.config;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.apicontatos.apicontatos.entities.Contato;
import com.apicontatos.apicontatos.repositories.ContatoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private ContatoRepository contatoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
		
		Date data1 = sdf.parse("27/01/2000");
		
		
		Contato c1 = new Contato("Vinicius", "Bacellar", data1, "33465107", "96901718132", "vinicius@gmail.com");
		Contato c2 = new Contato("João", "Silva", data1, "33007788", "981234673", "joao@gmail.com");
		Contato c3 = new Contato("Danilo", "Pinheiro", data1, "77885566", "928765453", "danilo@gmail.com");

		contatoRepository.saveAll(Arrays.asList(c1, c2, c3));
	}

}
