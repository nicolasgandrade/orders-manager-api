package com.nicolasgandrade.wsspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolasgandrade.wsspring.entities.Order;
import com.nicolasgandrade.wsspring.repositories.OrderRepository;

@Service //Registra a classe como um componente e permite que seja injetada com Autowired
public class OrderService {

	//A anotação "Autorwired" especifica que o spring deve mostrar no console o que está sendo feito
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	//Operação que encontra usuários pelo ID
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}
