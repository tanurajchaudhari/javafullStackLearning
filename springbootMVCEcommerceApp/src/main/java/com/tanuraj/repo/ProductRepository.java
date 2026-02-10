package com.tanuraj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tanuraj.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
