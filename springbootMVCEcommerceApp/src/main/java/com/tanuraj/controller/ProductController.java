package com.tanuraj.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tanuraj.entity.Product;
import com.tanuraj.repo.ProductRepository;

import jakarta.validation.Valid;

@Controller
public class ProductController {
	@Autowired
	ProductRepository productRepository;

	@GetMapping("/welcome")
	public String getWelcome(Model model) {
		model.addAttribute("msg","welcome to thymeleaf ");
		return "welcome";
	}
	@GetMapping("/")
	public String getForm(Model model) {
		Product product=new Product();
		model.addAttribute("product",product);
		return "product-form";
	}
	
	@PostMapping("/save")
	public String saveProduct(@Valid Product product,BindingResult result,Model model) {
	    if(result.hasErrors()) {
	    	System.err.println(result);
	    	return "product-form";
	    }
	    
	    
	    
		productRepository.save(product);
		model.addAttribute("msg","Product save successfullyy...");

		return "product-form";
	}
	@GetMapping("/products")
	public String getAllProduct(Model model) {
		List<Product> products = productRepository.findAll();
		model.addAttribute("products",products);
		return "AllProducts";
	}
	@GetMapping("/edit")
	public String editForm(@RequestParam("id") int id,Model model) {
		Optional<Product> byId = productRepository.findById(id);
		System.err.println("in edit form");
		if(byId.isPresent()) {
			Product product=byId.get();
			model.addAttribute("product",product);
		}
		return "edit-form";
	}
	@PostMapping("/edit-product")
	public String editProduct(@Valid Product product,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "edit-form";
		}
		productRepository.save(product);
		System.err.println("in save  edit product");
		return"redirect:/products";
	}
	
}
