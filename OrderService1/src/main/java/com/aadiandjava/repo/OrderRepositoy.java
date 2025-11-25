package com.aadiandjava.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aadiandjava.entity.Order;

public interface OrderRepositoy extends JpaRepository<Order, Integer>{
	

}
