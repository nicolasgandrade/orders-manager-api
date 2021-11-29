package com.nicolasgandrade.wsspring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolasgandrade.wsspring.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	//Instancia um objeto repository que vai servir para realizar operações com os dados
}
