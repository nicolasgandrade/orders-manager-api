package com.nicolasgandrade.wsspring.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolasgandrade.wsspring.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping //Significa que responde ao método get no caminho citado acima "/users"
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "999-999", "123456");//1L porque é long, exige o L na frente
		return ResponseEntity.ok().body(u);
	}
	
}
