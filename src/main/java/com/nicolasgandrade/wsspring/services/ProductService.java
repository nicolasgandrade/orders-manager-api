package com.nicolasgandrade.wsspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolasgandrade.wsspring.entities.Product;
import com.nicolasgandrade.wsspring.repositories.ProductRepository;

@Service //Registra a classe como um componente e permite que seja injetada com Autowired
public class ProductService {

	//A anotação "Autorwired" especifica que o spring deve mostrar no console o que está sendo feito
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	//Operação que encontra usuários pelo ID
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}
	
}
