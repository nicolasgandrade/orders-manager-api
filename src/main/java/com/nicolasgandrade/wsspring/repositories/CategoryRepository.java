package com.nicolasgandrade.wsspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolasgandrade.wsspring.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	//Instancia um objeto repository que vai servir para realizar operações com os dados

}
