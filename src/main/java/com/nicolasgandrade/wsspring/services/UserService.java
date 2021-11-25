package com.nicolasgandrade.wsspring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolasgandrade.wsspring.entities.User;
import com.nicolasgandrade.wsspring.repositories.UserRepository;

@Service //Registra a classe como um componente e permite que seja injetada com Autowired
public class UserService {

	//A anotação "Autorwired" especifica que o spring deve mostrar no console o que está sendo feito
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	//Operação que encontra usuários pelo ID
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
}
