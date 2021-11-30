package com.nicolasgandrade.wsspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolasgandrade.wsspring.entities.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	//Instancia um objeto repository que vai servir para realizar operações com os dados

}
