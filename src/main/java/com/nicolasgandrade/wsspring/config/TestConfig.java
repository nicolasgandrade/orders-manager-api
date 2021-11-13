package com.nicolasgandrade.wsspring.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nicolasgandrade.wsspring.entities.User;
import com.nicolasgandrade.wsspring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;

	//Executa o código assim que a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {

		//Instanciando os objetos a serem inseridos no banco
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999999", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "888888", "123456");
		
		//Recebe uma lista dos objetos a serem salvos; A lista está sendo criada inline;
		userRepository.saveAll(Arrays.asList(u1, u2));
	}

}
