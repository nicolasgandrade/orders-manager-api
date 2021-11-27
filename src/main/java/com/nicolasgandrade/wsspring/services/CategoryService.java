package com.nicolasgandrade.wsspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolasgandrade.wsspring.entities.Category;
import com.nicolasgandrade.wsspring.repositories.CategoryRepository;

@Service //Registra a classe como um componente e permite que seja injetada com Autowired
public class CategoryService {

	//A anotação "Autorwired" especifica que o spring deve mostrar no console o que está sendo feito
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	//Operação que encontra usuários pelo ID
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}
	
}
