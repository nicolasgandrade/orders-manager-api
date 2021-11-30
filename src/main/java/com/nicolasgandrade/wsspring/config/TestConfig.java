package com.nicolasgandrade.wsspring.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nicolasgandrade.wsspring.entities.Category;
import com.nicolasgandrade.wsspring.entities.Order;
import com.nicolasgandrade.wsspring.entities.OrderItem;
import com.nicolasgandrade.wsspring.entities.Product;
import com.nicolasgandrade.wsspring.entities.User;
import com.nicolasgandrade.wsspring.entities.enums.OrderStatus;
import com.nicolasgandrade.wsspring.repositories.CategoryRepository;
import com.nicolasgandrade.wsspring.repositories.OrderItemRepository;
import com.nicolasgandrade.wsspring.repositories.OrderRepository;
import com.nicolasgandrade.wsspring.repositories.ProductRepository;
import com.nicolasgandrade.wsspring.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	//Executa o código assim que a aplicação for iniciada
	@Override
	public void run(String... args) throws Exception {

		//Instanciando os objetos a serem inseridos no banco
		
		Category cat1 = new Category(null, "Books");
		Category cat2 = new Category(null, "Clothes");
		Category cat3 = new Category(null, "Electronics");
		Category cat4 = new Category(null, "For home");
		
		Product p1 = new Product (null, "The Lord of the Rings", "Lorem Ipsum", 15.0, "");
		Product p2 = new Product (null, "IPhone13", "Lorem Ipsum", 450.0, "");
		Product p3 = new Product (null, "Television", "Lorem Ipsum", 350.0, "");
		
		//Salva as categorias e os produtos no banco
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		//Associa as categorias aos produtos salvos anteriormente
		
		p1.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		//P3 pertence a DUAS categorias
		p3.getCategories().add(cat3);
		p3.getCategories().add(cat4);
		
		//Salva as alterações nos produtos
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
		// --> erro
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "999999", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "888888", "123456");
		
		//				    (ID a ser gerado, data no formato ISO 8601, usuário que pediu)
		Order o1 = new Order(null, Instant.parse("2021-11-27T14:36:02Z"), OrderStatus.DELIVERED, u1);
		Order o2 = new Order(null, Instant.parse("2021-11-28T14:36:02Z"), OrderStatus.PAID, u1);
		Order o3 = new Order(null, Instant.parse("2021-11-29T14:36:02Z"), OrderStatus.PAID, u2);
		
		//Recebe uma lista dos objetos a serem salvos; A lista está sendo criada inline;
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o2, p2, 4, p2.getPrice());
		OrderItem oi3 = new OrderItem(o3, p3, 1, p3.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));
	}

}
