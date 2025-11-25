package com.aadiandjava.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadiandjava.entity.Product;
import com.aadiandjava.repo.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	@Autowired
	ProductRepository productRepository;
    @PostMapping("/save")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		Product savedProduct = productRepository.save(product);
		
		return new ResponseEntity<Product>(savedProduct,HttpStatus.CREATED);
		
	}
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
    	     return new ResponseEntity<List<Product>>(productRepository.findAll(),HttpStatus.OK);
    }
}
