package com.tanuraj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message="Prduct name can not be blank")
	@Size(min=5,max=10,message="name should be greater than 5 char and less than upto 10 char") 
	private String name;
	@NotNull(message="price cannot be null")
	@Positive(message="price should be positive")
	private Double price;
	@NotNull(message="quantity cannot be null")
	@Positive(message="quantity should be positive")
	private Integer qyt;
	

}
