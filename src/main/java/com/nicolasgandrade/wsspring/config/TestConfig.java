package com.nicolasgandrade.wsspring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nicolasgandrade.wsspring.entities.Order;
import com.nicolasgandrade.wsspring.entities.User;
import com.nicolasgandrade.wsspring.repositories.OrderRepository;
import com.nicolasgandrade.wsspring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	//Executa o código assim que a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {

		//Instanciando os objetos a serem inseridos no banco
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999999", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "888888", "123456");
		
		//				    (ID a ser gerado, data no formato ISO 8601, usuário que pediu)
		Order o1 = new Order(null, Instant.parse("2021-11-27T14:36:02Z"), u1);
		Order o2 = new Order(null, Instant.parse("2021-11-28T14:36:02Z"), u1);
		Order o3 = new Order(null, Instant.parse("2021-11-29T14:36:02Z"), u2);
		
		//Recebe uma lista dos objetos a serem salvos; A lista está sendo criada inline;
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}

}
