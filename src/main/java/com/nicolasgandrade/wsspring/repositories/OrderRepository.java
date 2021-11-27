package com.nicolasgandrade.wsspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolasgandrade.wsspring.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	//Instancia um objeto repository que vai servir para realizar operações com os dados

}
