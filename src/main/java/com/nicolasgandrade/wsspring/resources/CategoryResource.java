package com.nicolasgandrade.wsspring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolasgandrade.wsspring.entities.Category;
import com.nicolasgandrade.wsspring.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService service;
	
	@GetMapping //Significa que responde ao método get no caminho citado acima "/users"
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		//Este método já retorna em formato JSON
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){ //A anotação envia o id passado na URL como parâmetro
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
